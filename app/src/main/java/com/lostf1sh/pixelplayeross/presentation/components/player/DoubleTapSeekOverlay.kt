package com.lostf1sh.pixelplayeross.presentation.components.player

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FastForward
import androidx.compose.material.icons.rounded.FastRewind
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class SeekGestureDirection {
    BACKWARD, FORWARD
}

/**
 * Overlay placed above album art carousel providing double-tap to seek (±10s)
 * with animated feedback pills and haptic responses.
 */
@Composable
fun DoubleTapSeekOverlay(
    onSeekRelative: (deltaMs: Long) -> Unit,
    modifier: Modifier = Modifier,
    onSingleTap: () -> Unit = {},
    content: @Composable () -> Unit
) {
    val haptic = LocalHapticFeedback.current
    var activeDirection by remember { mutableStateOf<SeekGestureDirection?>(null) }
    var seekMultiplier by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()

    BoxWithConstraints(modifier = modifier) {
        content()

        Row(modifier = Modifier.fillMaxSize()) {
            // Left 38% detection zone (Rewind -10s)
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.38f)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = { onSingleTap() },
                            onDoubleTap = {
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                onSeekRelative(-10_000L)
                                activeDirection = SeekGestureDirection.BACKWARD
                                seekMultiplier++
                                scope.launch {
                                    delay(700)
                                    if (activeDirection == SeekGestureDirection.BACKWARD) {
                                        activeDirection = null
                                        seekMultiplier = 0
                                    }
                                }
                            }
                        )
                    }
            )

            // Center 24% pass-through
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.24f)
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = { onSingleTap() })
                    }
            )

            // Right 38% detection zone (Forward +10s)
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.38f)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = { onSingleTap() },
                            onDoubleTap = {
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                onSeekRelative(10_000L)
                                activeDirection = SeekGestureDirection.FORWARD
                                seekMultiplier++
                                scope.launch {
                                    delay(700)
                                    if (activeDirection == SeekGestureDirection.FORWARD) {
                                        activeDirection = null
                                        seekMultiplier = 0
                                    }
                                }
                            }
                        )
                    }
            )
        }

        // Animated Seek Pill
        AnimatedVisibility(
            visible = activeDirection != null,
            enter = fadeIn(tween(150)) + scaleIn(tween(150, easing = FastOutSlowInEasing)),
            exit = fadeOut(tween(250)) + scaleOut(tween(250)),
            modifier = Modifier
                .align(
                    if (activeDirection == SeekGestureDirection.BACKWARD) Alignment.CenterStart else Alignment.CenterEnd
                )
                .padding(horizontal = 24.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surfaceContainerHighest.copy(alpha = 0.90f),
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (activeDirection == SeekGestureDirection.BACKWARD) {
                        Icon(
                            imageVector = Icons.Rounded.FastRewind,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = "-${10 * seekMultiplier.coerceAtLeast(1)}s",
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    } else {
                        Text(
                            text = "+${10 * seekMultiplier.coerceAtLeast(1)}s",
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Spacer(Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.Rounded.FastForward,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}
