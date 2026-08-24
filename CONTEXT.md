# Tonarc Domain Model & Architecture

A native Material 3 Expressive Android music player supporting offline local playback, high-fidelity audio processing (gapless playback, smart crossfade, pitch/tempo), and multi-source cloud and streaming backends (Navidrome, Jellyfin, YouTube Music).

## Language

**YouTube Music Stream**:
A live-streamed audio track resolved dynamically via client-side Innertube extractor and proxied through `CloudStreamProxy`.
_Avoid_: Web stream, YouTube video, external URL

**Library Source Mode**:
The active filter controlling library display across Local Media, YouTube Music, Navidrome, Jellyfin, or Unified mode.
_Avoid_: Tab switch, cloud toggle, account selector

**Hybrid Playlist**:
A playlist containing an arbitrary mix of local audio files, synced YouTube Music tracks, and downloaded cloud media.
_Avoid_: Cloud playlist, multi-source list

**Cloud Track Download**:
An offline cached copy of a remote stream stored on device and played seamlessly via `OfflineTrackDao` without network connection.
_Avoid_: Local cache, YouTube rip, offline save

**Innertube Client**:
The embedded Kotlin client querying YouTube Music's internal API directly with persistent `visitorData` caching without intermediary proxy servers.
_Avoid_: YouTube scraper, bot, backend proxy

**Dual Player Engine**:
The multi-ExoPlayer audio pipeline orchestrating seamless crossfade, smart gapless transitions, and custom audio processor chains.
_Avoid_: ExoPlayer wrapper, playback engine

**Personalized Ranker**:
The on-device ranking and recommendation engine that personalizes mix feeds, artist variety, and candidate aggregation.
_Avoid_: AI model, remote recommendation server

**Unified UI Surface**:
The single set of player sheets, widgets, equalizers, carousels, and lyrics components shared identically across local files and cloud streams without visual or functional divergence.
_Avoid_: Dual UI, YouTube mode, streaming player

---

## Codebase Map & Inventory

- **Total Tracked Files**: 1065
- **Total Lines of Code**: 375,569
- **Primary Language**: Kotlin (Android / Jetpack Compose / Media3 / Room / Hilt / Glance)

---


## `[Root]` (16 files, 3,819 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AGENTS.md](file:///home/dharshan/PixelPlayerOSS/AGENTS.md) | 43 | - |
| [CHANGELOG.md](file:///home/dharshan/PixelPlayerOSS/CHANGELOG.md) | 90 | - |
| [CONTEXT.md](file:///home/dharshan/PixelPlayerOSS/CONTEXT.md) | 1937 | - |
| [CONTRIBUTING.md](file:///home/dharshan/PixelPlayerOSS/CONTRIBUTING.md) | 79 | - |
| [LICENSE](file:///home/dharshan/PixelPlayerOSS/LICENSE) | 674 | - |
| [PRIVACY.md](file:///home/dharshan/PixelPlayerOSS/PRIVACY.md) | 31 | - |
| [README.md](file:///home/dharshan/PixelPlayerOSS/README.md) | 277 | - |
| [SECURITY.md](file:///home/dharshan/PixelPlayerOSS/SECURITY.md) | 15 | - |
| [THIRD_PARTY_NOTICES.md](file:///home/dharshan/PixelPlayerOSS/THIRD_PARTY_NOTICES.md) | 47 | - |
| [build.gradle.kts](file:///home/dharshan/PixelPlayerOSS/build.gradle.kts) | 10 | - |
| [gradle.properties](file:///home/dharshan/PixelPlayerOSS/gradle.properties) | 33 | - |
| [gradlew](file:///home/dharshan/PixelPlayerOSS/gradlew) | 248 | - |
| [gradlew.bat](file:///home/dharshan/PixelPlayerOSS/gradlew.bat) | 82 | - |
| [lint.xml](file:///home/dharshan/PixelPlayerOSS/lint.xml) | 4 | - |
| [settings.gradle.kts](file:///home/dharshan/PixelPlayerOSS/settings.gradle.kts) | 34 | - |
| [skills-lock.json](file:///home/dharshan/PixelPlayerOSS/skills-lock.json) | 215 | - |

## `app` (4 files, 1,048 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [build.gradle.kts](file:///home/dharshan/PixelPlayerOSS/app/build.gradle.kts) | 332 | - |
| [compose_stability.conf](file:///home/dharshan/PixelPlayerOSS/app/compose_stability.conf) | 25 | - |
| [performance_analysis.md](file:///home/dharshan/PixelPlayerOSS/app/performance_analysis.md) | 607 | - |
| [proguard-rules.pro](file:///home/dharshan/PixelPlayerOSS/app/proguard-rules.pro) | 84 | - |

## `app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase` (6 files, 13,101 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [1.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/1.json) | 2010 | - |
| [2.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/2.json) | 2036 | - |
| [3.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/3.json) | 2121 | - |
| [4.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/4.json) | 2180 | - |
| [5.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/5.json) | 2301 | - |
| [6.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/6.json) | 2453 | - |

## `app/schemas/com.quietrays.tonarc.data.database.TonarcDatabase` (7 files, 15,643 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [1.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.quietrays.tonarc.data.database.TonarcDatabase/1.json) | 2010 | - |
| [2.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.quietrays.tonarc.data.database.TonarcDatabase/2.json) | 2036 | - |
| [3.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.quietrays.tonarc.data.database.TonarcDatabase/3.json) | 2121 | - |
| [4.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.quietrays.tonarc.data.database.TonarcDatabase/4.json) | 2180 | - |
| [5.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.quietrays.tonarc.data.database.TonarcDatabase/5.json) | 2301 | - |
| [6.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.quietrays.tonarc.data.database.TonarcDatabase/6.json) | 2453 | - |
| [8.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.quietrays.tonarc.data.database.TonarcDatabase/8.json) | 2542 | - |

## `app/src/androidTest/java/com/quietrays/tonarc/benchmark` (1 files, 24 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [StartupBenchmark.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/quietrays/tonarc/benchmark/StartupBenchmark.kt) | 24 | `class StartupBenchmark`, `fun placeholder`, `class BaselineProfileGenerator`, `fun placeholder` |

## `app/src/androidTest/java/com/quietrays/tonarc/data/database` (2 files, 255 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [EngagementDaoTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/quietrays/tonarc/data/database/EngagementDaoTest.kt) | 81 | `class EngagementDaoTest`, `fun createDb`, `fun closeDb`, `fun recordPlay_upsertsPlayCountAndDuration`, `fun recordSkip_incrementsSkipCount`, `fun recordCompletion_incrementsCompletionCount` |
| [MusicDaoTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/quietrays/tonarc/data/database/MusicDaoTest.kt) | 174 | `class MusicDaoTest`, `fun createDb`, `fun closeDb`, `fun createSongEntity`, `fun createAlbumEntity`, `fun createArtistEntity` |

## `app/src/androidTest/java/com/quietrays/tonarc/data/service` (1 files, 301 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MusicServiceWorkflowTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/quietrays/tonarc/data/service/MusicServiceWorkflowTest.kt) | 301 | `class MusicServiceWorkflowTest`, `interface WorkflowTestEntryPoint`, `fun musicDao`, `fun setUp`, `fun tearDown`, `fun controllerFromOwnAppReceivesCustomSessionCommands` |

## `app/src/androidTest/java/com/quietrays/tonarc/data/worker` (1 files, 175 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SyncWorkerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/quietrays/tonarc/data/worker/SyncWorkerTest.kt) | 175 | `class SyncWorkerTest`, `class TestSyncWorkerFactory`, `fun setUp`, `fun tearDown`, `fun createMockSongCursor`, `fun createMockAlbumCursor` |

## `app/src/androidTest/java/com/quietrays/tonarc/presentation/components` (1 files, 79 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [WavySliderExpressiveTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/quietrays/tonarc/presentation/components/WavySliderExpressiveTest.kt) | 79 | `class WavySliderExpressiveTest`, `fun reportedProgress`, `fun followsValueAfterBackingStateIsReplaced`, `fun reportsNonFiniteValueAsZero` |

## `app/src/benchmark` (1 files, 6 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AndroidManifest.xml](file:///home/dharshan/PixelPlayerOSS/app/src/benchmark/AndroidManifest.xml) | 6 | - |

## `app/src/debug/res/values` (1 files, 4 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/debug/res/values/strings.xml) | 4 | - |

## `app/src/debug/res/xml` (1 files, 9 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [network_security_config.xml](file:///home/dharshan/PixelPlayerOSS/app/src/debug/res/xml/network_security_config.xml) | 9 | - |

## `app/src/main` (2 files, 527 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AndroidManifest.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/AndroidManifest.xml) | 248 | - |
| [ic_launcher-playstore.png](file:///home/dharshan/PixelPlayerOSS/app/src/main/ic_launcher-playstore.png) | 279 | - |

## `app/src/main/assets` (1 files, 1 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [vm_new.js](file:///home/dharshan/PixelPlayerOSS/app/src/main/assets/vm_new.js) | 1 | - |

## `app/src/main/assets/licenses` (2 files, 121 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [OFL.txt](file:///home/dharshan/PixelPlayerOSS/app/src/main/assets/licenses/OFL.txt) | 101 | - |
| [THIRD_PARTY_NOTICES.md](file:///home/dharshan/PixelPlayerOSS/app/src/main/assets/licenses/THIRD_PARTY_NOTICES.md) | 20 | - |

## `app/src/main/java/com/quietrays/tonarc` (5 files, 1,496 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExternalPlayerActivity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ExternalPlayerActivity.kt) | 151 | `class ExternalPlayerActivity`, `fun handleIntent`, `fun openFullPlayer`, `fun resolveStreamUri`, `fun persistUriPermissionIfNeeded`, `fun clearExternalIntentPayload` |
| [MainActivity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/MainActivity.kt) | 1134 | `class BottomNavItem`, `class DismissUndoBarSlice`, `class MainActivity`, `fun handleIntent`, `fun resolveStreamUri`, `fun persistUriPermissionIfNeeded` |
| [MainActivityIntentContract.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/MainActivityIntentContract.kt) | 7 | `object MainActivityIntentContract` |
| [ReleaseTree.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ReleaseTree.kt) | 27 | `class ReleaseTree` |
| [TonarcApplication.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/TonarcApplication.kt) | 177 | `class TonarcApplication` |

## `app/src/main/java/com/quietrays/tonarc/data` (2 files, 672 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DailyMixManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/DailyMixManager.kt) | 647 | `class DailyMixManager`, `class SongEngagementStats`, `fun readLegacyEngagementsLocked`, `fun parseEngagementElement`, `fun parseEngagementObject`, `fun parseStatsValue` |
| [EotStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/EotStateHolder.kt) | 25 | `object EotStateHolder`, `fun setEotTargetSong` |

## `app/src/main/java/com/quietrays/tonarc/data/backup` (2 files, 853 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AppDataBackupManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/AppDataBackupManager.kt) | 497 | `class BackupSection`, `class BackupOperationType`, `class BackupTransferProgressUpdate`, `class PlaybackHistoryBackupEntry`, `class AppDataBackupPayload`, `class AppDataBackupManager` |
| [BackupManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/BackupManager.kt) | 356 | `class BackupManager`, `fun getBackupHistory`, `fun discardDecryptedBackup`, `fun copyLimited`, `fun skipFully`, `fun reportProgress` |

## `app/src/main/java/com/quietrays/tonarc/data/backup/format` (5 files, 676 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupCrypto.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/format/BackupCrypto.kt) | 106 | `class BackupEncryptedException`, `class BackupWrongPassphraseException`, `object BackupCrypto`, `fun encryptingStream`, `fun decryptingStream`, `fun deriveKey` |
| [BackupFormatDetector.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/format/BackupFormatDetector.kt) | 67 | `class BackupFormatDetector`, `class Format`, `fun detect`, `fun readHeader` |
| [BackupReader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/format/BackupReader.kt) | 279 | `class BackupReader`, `fun detectFormatInternal`, `fun readManifestFromZip`, `fun readEntryFromZip`, `fun readAllEntriesFromZip`, `fun isSuspiciousEntryName` |
| [BackupWriter.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/format/BackupWriter.kt) | 95 | `class BackupWriter`, `fun sha256`, `fun countJsonArrayEntries` |
| [LegacyPayloadAdapter.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/format/LegacyPayloadAdapter.kt) | 129 | `class LegacyPayloadAdapter`, `fun adapt`, `fun splitLegacyPreferences`, `fun extractJsonArrayModule`, `fun buildModuleInfo`, `fun countEntries` |

## `app/src/main/java/com/quietrays/tonarc/data/backup/history` (1 files, 73 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupHistoryRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/history/BackupHistoryRepository.kt) | 73 | `class BackupHistoryRepository`, `fun readHistory` |

## `app/src/main/java/com/quietrays/tonarc/data/backup/model` (3 files, 203 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupManifest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/model/BackupManifest.kt) | 28 | `class BackupManifest`, `class DeviceInfo`, `class BackupModuleInfo` |
| [BackupModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/model/BackupModels.kt) | 88 | `class BackupOperationType`, `class BackupTransferProgressUpdate`, `class PlaybackHistoryBackupEntry`, `class ArtistImageBackupEntry`, `class BackupHistoryEntry`, `class RestorePlan` |
| [BackupSection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/model/BackupSection.kt) | 87 | `class BackupSection`, `fun fromKey` |

## `app/src/main/java/com/quietrays/tonarc/data/backup/module` (12 files, 1,045 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ArtistImagesModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/ArtistImagesModuleHandler.kt) | 123 | `class ArtistImagesModuleHandler`, `fun readFileAsBase64` |
| [BackupModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/BackupModuleHandler.kt) | 22 | `interface BackupModuleHandler` |
| [EngagementStatsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/EngagementStatsModuleHandler.kt) | 165 | `class EngagementStatsModuleHandler`, `fun parseEntries`, `fun parseEntry`, `fun mergeEntries`, `fun readString`, `fun readInt` |
| [EqualizerModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/EqualizerModuleHandler.kt) | 52 | `class EqualizerModuleHandler` |
| [FavoritesModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/FavoritesModuleHandler.kt) | 39 | `class FavoritesModuleHandler` |
| [GlobalSettingsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/GlobalSettingsModuleHandler.kt) | 57 | `class GlobalSettingsModuleHandler` |
| [LyricsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/LyricsModuleHandler.kt) | 39 | `class LyricsModuleHandler` |
| [PlaybackHistoryModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/PlaybackHistoryModuleHandler.kt) | 59 | `class PlaybackHistoryModuleHandler` |
| [PlaylistsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/PlaylistsModuleHandler.kt) | 359 | `class PlaylistsModuleHandler`, `fun readFileAsBase64`, `fun restoreCoverImages`, `fun resolveSongId`, `fun metadataMatches`, `fun normalizeMatchKey` |
| [QuickFillModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/QuickFillModuleHandler.kt) | 52 | `class QuickFillModuleHandler` |
| [SearchHistoryModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/SearchHistoryModuleHandler.kt) | 39 | `class SearchHistoryModuleHandler` |
| [TransitionsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/module/TransitionsModuleHandler.kt) | 39 | `class TransitionsModuleHandler` |

## `app/src/main/java/com/quietrays/tonarc/data/backup/restore` (2 files, 213 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [RestoreExecutor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/restore/RestoreExecutor.kt) | 157 | `class RestoreExecutor`, `fun reportProgress` |
| [RestorePlanner.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/restore/RestorePlanner.kt) | 56 | `class RestorePlanner` |

## `app/src/main/java/com/quietrays/tonarc/data/backup/validation` (5 files, 766 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupFileValidator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/validation/BackupFileValidator.kt) | 177 | `class BackupFileValidator`, `fun validate`, `fun validateZipSafety`, `fun skipFully` |
| [ContentSanitizer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/validation/ContentSanitizer.kt) | 36 | `class ContentSanitizer`, `fun sanitizeString`, `fun sanitizeUrl`, `fun isValidModuleKey` |
| [ManifestValidator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/validation/ManifestValidator.kt) | 80 | `class ManifestValidator`, `fun validate`, `fun verifyChecksum`, `fun sha256` |
| [ModuleSchemaValidator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/validation/ModuleSchemaValidator.kt) | 403 | `class ModuleSchemaValidator`, `class NumericFieldResult`, `fun validate`, `fun validatePlaylistsModule`, `fun validateFavorites`, `fun validateLyrics` |
| [ValidationPipeline.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/backup/validation/ValidationPipeline.kt) | 70 | `class ValidationPipeline`, `fun validateFile`, `fun validateManifest`, `fun validateModulePayload`, `fun collectWarnings` |

## `app/src/main/java/com/quietrays/tonarc/data/database` (43 files, 4,596 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtThemeDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/AlbumArtThemeDao.kt) | 20 | `interface AlbumArtThemeDao` |
| [AlbumArtThemeEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/AlbumArtThemeEntity.kt) | 70 | `class StoredColorSchemeValues`, `class AlbumArtThemeEntity` |
| [AlbumEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/AlbumEntity.kt) | 69 | `class AlbumEntity`, `fun AlbumEntity`, `fun List`, `fun Album` |
| [ArtistEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/ArtistEntity.kt) | 44 | `class ArtistEntity`, `fun ArtistEntity`, `fun List`, `fun Artist` |
| [AudioBookmarkDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/AudioBookmarkDao.kt) | 41 | `interface AudioBookmarkDao`, `fun getAllBookmarksFlow` |
| [AudioBookmarkEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/AudioBookmarkEntity.kt) | 17 | `class AudioBookmarkEntity` |
| [ColorConverters.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/ColorConverters.kt) | 12 | `fun String` |
| [EngagementDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/EngagementDao.kt) | 112 | `interface EngagementDao`, `fun getAllEngagementsFlow` |
| [FavoritesDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/FavoritesDao.kt) | 44 | `interface FavoritesDao`, `fun getFavoriteSongIdsRaw`, `fun getFavoriteSongIds` |
| [FavoritesEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/FavoritesEntity.kt) | 22 | `class FavoritesEntity` |
| [FolderSongRow.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/FolderSongRow.kt) | 13 | `class FolderSongRow` |
| [ItemCooccurrenceDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/ItemCooccurrenceDao.kt) | 51 | `interface ItemCooccurrenceDao` |
| [ItemCooccurrenceEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/ItemCooccurrenceEntity.kt) | 32 | `class ItemCooccurrenceEntity` |
| [JellyfinDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/JellyfinDao.kt) | 88 | `interface JellyfinDao`, `fun getAllJellyfinSongs`, `fun getSongsByPlaylist`, `fun searchSongs`, `fun getSongsByIds`, `fun getAllPlaylists` |
| [JellyfinPlaylistEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/JellyfinPlaylistEntity.kt) | 14 | `class JellyfinPlaylistEntity` |
| [JellyfinSongEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/JellyfinSongEntity.kt) | 83 | `class JellyfinSongEntity`, `fun JellyfinSongEntity`, `fun JellyfinSong` |
| [ListenBrainzDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/ListenBrainzDao.kt) | 45 | `interface ListenBrainzDao`, `fun countFlow` |
| [ListenBrainzPendingListenEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/ListenBrainzPendingListenEntity.kt) | 41 | `class ListenBrainzPendingListenEntity`, `object ListenBrainzSource`, `fun fromSourceType` |
| [LocalPlaylistDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/LocalPlaylistDao.kt) | 74 | `interface LocalPlaylistDao`, `fun observePlaylistsWithSongs`, `fun observePlaylistWithSongs`, `fun observePlaylistSongs` |
| [LyricsDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/LyricsDao.kt) | 37 | `interface LyricsDao` |
| [LyricsEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/LyricsEntity.kt) | 18 | `class LyricsEntity` |
| [Migrations.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/Migrations.kt) | 249 | `fun SupportSQLiteDatabase`, `fun SupportSQLiteDatabase` |
| [MusicDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/MusicDao.kt) | 2043 | `fun buildSongTitleSearchMatchQuery`, `fun buildSongSearchMatchQuery`, `class DeviceCapabilitySongRow`, `class LibraryAudioStatsRow`, `class MimeTypeCountRow`, `interface MusicDao` |
| [NavidromeDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/NavidromeDao.kt) | 91 | `interface NavidromeDao`, `fun getAllNavidromeSongs`, `fun getSongsByPlaylist`, `fun getLibrarySongCount`, `fun searchSongs`, `fun getSongsByIds` |
| [NavidromePlaylistEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/NavidromePlaylistEntity.kt) | 31 | `class NavidromePlaylistEntity` |
| [NavidromeSongEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/NavidromeSongEntity.kt) | 117 | `class NavidromeSongEntity`, `fun NavidromeSongEntity`, `fun NavidromeSong` |
| [OfflineTrackDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/OfflineTrackDao.kt) | 69 | `interface OfflineTrackDao`, `fun observeBySourceUri`, `fun observeCompleted`, `fun observeAll` |
| [OfflineTrackEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/OfflineTrackEntity.kt) | 39 | `class OfflineTrackEntity` |
| [PlaylistEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/PlaylistEntity.kt) | 84 | `class PlaylistEntity`, `fun PlaylistEntity`, `fun Playlist` |
| [PlaylistSongEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/PlaylistSongEntity.kt) | 22 | `class PlaylistSongEntity` |
| [PlaylistWithSongsEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/PlaylistWithSongsEntity.kt) | 15 | `class PlaylistWithSongsEntity` |
| [SearchHistoryDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/SearchHistoryDao.kt) | 34 | `interface SearchHistoryDao` |
| [SearchHistoryEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/SearchHistoryEntity.kt) | 36 | `class SearchHistoryEntity`, `fun SearchHistoryEntity`, `fun SearchHistoryItem` |
| [SongArtistCrossRef.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/SongArtistCrossRef.kt) | 87 | `class SongArtistCrossRef`, `class SongWithArtists`, `class ArtistWithSongs`, `class PrimaryArtistInfo` |
| [SongEngagementEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/SongEngagementEntity.kt) | 59 | `class SongEngagementEntity` |
| [SongEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/SongEntity.kt) | 263 | `object SourceType`, `fun fromContentUri`, `class SongEntity`, `fun SongEntity`, `fun SongEntity`, `fun parseArtistsJson` |
| [SongSearchFtsEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/SongSearchFtsEntity.kt) | 18 | `class SongSearchFtsEntity` |
| [TonarcDatabase.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/TonarcDatabase.kt) | 154 | `class TonarcDatabase`, `fun albumArtThemeDao`, `fun searchHistoryDao`, `fun musicDao`, `fun transitionDao`, `fun engagementDao` |
| [TransitionDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/TransitionDao.kt) | 67 | `interface TransitionDao`, `fun getPlaylistDefaultRule`, `fun getSpecificRule`, `fun getAllRulesForPlaylist` |
| [TransitionRuleEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/TransitionRuleEntity.kt) | 27 | `class TransitionRuleEntity` |
| [YouTubeDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/YouTubeDao.kt) | 71 | `interface YouTubeDao`, `fun getAllYouTubeSongs`, `fun getSongsByPlaylist`, `fun getLibrarySongCount`, `fun searchSongs`, `fun getSongsByIds` |
| [YouTubePlaylistEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/YouTubePlaylistEntity.kt) | 19 | `class YouTubePlaylistEntity` |
| [YouTubeSongEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/database/YouTubeSongEntity.kt) | 54 | `class YouTubeSongEntity`, `fun toSong` |

## `app/src/main/java/com/quietrays/tonarc/data/diagnostics` (6 files, 1,233 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AdvancedPerformanceDiagnostics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/diagnostics/AdvancedPerformanceDiagnostics.kt) | 238 | `object AdvancedPerformanceDiagnostics`, `object EventTypes`, `class DiagnosticEvent`, `class Snapshot`, `fun startSession`, `fun configureSession` |
| [AdvancedPerformanceDiagnosticsController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/diagnostics/AdvancedPerformanceDiagnosticsController.kt) | 50 | `class AdvancedPerformanceDiagnosticsController`, `fun start` |
| [DebugPerformanceReport.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/diagnostics/DebugPerformanceReport.kt) | 348 | `class DebugPerformanceReport`, `fun toJson`, `fun toPlainText`, `fun StringBuilder`, `fun StringBuilder`, `fun bytes` |
| [DebugPerformanceReportCollector.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/diagnostics/DebugPerformanceReportCollector.kt) | 276 | `class DebugPerformanceReportCollector`, `class EngineState`, `fun collectDevice`, `fun collectApp`, `fun collectLibrary`, `fun collectHiRes` |
| [MainThreadStallMonitor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/diagnostics/MainThreadStallMonitor.kt) | 50 | `class MainThreadStallMonitor`, `fun start`, `fun stop` |
| [PerformanceMetrics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/diagnostics/PerformanceMetrics.kt) | 271 | `object PerformanceMetrics`, `object Timings`, `object Counters`, `object Maxes`, `class TimingStat`, `fun record` |

## `app/src/main/java/com/quietrays/tonarc/data/equalizer` (3 files, 758 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [EqualizerManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/equalizer/EqualizerManager.kt) | 584 | `class EqualizerManager`, `fun checkDeviceSupport`, `fun markBassBoostUnavailable`, `fun markVirtualizerUnavailable`, `fun setEnabled`, `fun setBandLevel` |
| [EqualizerPreset.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/equalizer/EqualizerPreset.kt) | 97 | `class EqualizerPreset`, `fun custom`, `fun fromName` |
| [ExternalAudioEffectSession.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/equalizer/ExternalAudioEffectSession.kt) | 77 | `class ExternalAudioEffectSession`, `fun open`, `fun close`, `fun broadcast` |

## `app/src/main/java/com/quietrays/tonarc/data/image` (3 files, 363 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinCoilFetcher.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/image/JellyfinCoilFetcher.kt) | 156 | `class JellyfinCoilFetcher`, `fun shouldLogFailure`, `fun downloadImage`, `class Factory` |
| [LocalArtworkCoilFetcher.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/image/LocalArtworkCoilFetcher.kt) | 45 | `class LocalArtworkCoilFetcher`, `class Factory` |
| [NavidromeCoilFetcher.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/image/NavidromeCoilFetcher.kt) | 162 | `class NavidromeCoilFetcher`, `fun shouldLogFailure`, `class Factory` |

## `app/src/main/java/com/quietrays/tonarc/data/jellyfin` (2 files, 823 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/jellyfin/JellyfinRepository.kt) | 753 | `class JellyfinRepository`, `fun createEncryptedPrefs`, `fun createCredentialPrefs`, `fun initFromSavedCredentials`, `fun getAuthorizationHeader`, `fun getPlaylists` |
| [JellyfinStreamProxy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/jellyfin/JellyfinStreamProxy.kt) | 70 | `class JellyfinStreamProxy`, `fun resolveJellyfinUri` |

## `app/src/main/java/com/quietrays/tonarc/data/jellyfin/model` (6 files, 239 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinAlbum.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/jellyfin/model/JellyfinAlbum.kt) | 31 | `class JellyfinAlbum`, `fun empty` |
| [JellyfinArtist.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/jellyfin/model/JellyfinArtist.kt) | 21 | `class JellyfinArtist`, `fun empty` |
| [JellyfinCredentials.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/jellyfin/model/JellyfinCredentials.kt) | 74 | `class JellyfinCredentials`, `fun empty`, `fun connectionValidationError`, `fun isHttpAllowedHost` |
| [JellyfinLibrary.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/jellyfin/model/JellyfinLibrary.kt) | 31 | `class JellyfinLibrary` |
| [JellyfinPlaylist.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/jellyfin/model/JellyfinPlaylist.kt) | 27 | `class JellyfinPlaylist`, `fun empty` |
| [JellyfinSong.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/jellyfin/model/JellyfinSong.kt) | 55 | `class JellyfinSong`, `fun empty` |

## `app/src/main/java/com/quietrays/tonarc/data/library` (1 files, 65 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DuplicateFinder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/library/DuplicateFinder.kt) | 65 | `object DuplicateFinder`, `class DuplicateGroup`, `fun normalize`, `fun findDuplicates`, `fun MutableList` |

## `app/src/main/java/com/quietrays/tonarc/data/listenbrainz` (7 files, 810 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ListenBrainzApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/listenbrainz/ListenBrainzApiService.kt) | 38 | `interface ListenBrainzApiService` |
| [ListenBrainzEndpoint.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/listenbrainz/ListenBrainzEndpoint.kt) | 53 | `class ListenBrainzEndpoint`, `fun setCustom`, `fun rewrite`, `fun parseBaseUrl` |
| [ListenBrainzLabsApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/listenbrainz/ListenBrainzLabsApiService.kt) | 29 | `interface ListenBrainzLabsApiService` |
| [ListenBrainzLabsModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/listenbrainz/ListenBrainzLabsModels.kt) | 41 | `class LbSimilarArtistsResponse`, `class LbSimilarArtistItem`, `class SimilarArtist`, `class LbRadioResponse`, `class LbRadioPayload`, `class LbRadioRecording` |
| [ListenBrainzModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/listenbrainz/ListenBrainzModels.kt) | 113 | `class ListenBrainzSubmission`, `class ListenBrainzListen`, `class ListenBrainzTrackMetadata`, `class ListenBrainzAdditionalInfo`, `class ListenBrainzTokenValidation`, `class ListenBrainzListenCountResponse` |
| [ListenBrainzRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/listenbrainz/ListenBrainzRepository.kt) | 398 | `class InvalidServerUrlException`, `class ListenBrainzRepository`, `fun createEncryptedPrefs`, `fun createCredentialPrefs`, `fun hasToken`, `fun isAuthorized` |
| [ScrobbleManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/listenbrainz/ScrobbleManager.kt) | 138 | `class ScrobbleManager`, `fun onSessionFinalized`, `fun onPlayingNow`, `fun meetsListenThreshold` |

## `app/src/main/java/com/quietrays/tonarc/data/media` (9 files, 2,213 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AudioMetadataReader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/media/AudioMetadataReader.kt) | 234 | `class AudioMetadata`, `class AudioMetadataArtwork`, `object AudioMetadataReader`, `fun read`, `fun read`, `fun readWithJAudioTagger` |
| [AudioMetadataUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/media/AudioMetadataUtils.kt) | 144 | `fun createTempAudioFileFromUri`, `fun resolveAudioFileExtension`, `fun normalizeExtension`, `fun isValidImageData`, `fun imageExtensionFromMimeType`, `fun guessImageMimeType` |
| [ImageCacheManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/media/ImageCacheManager.kt) | 38 | `class ImageCacheManager`, `fun invalidateCoverArtCaches` |
| [MediaControllerFactory.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/media/MediaControllerFactory.kt) | 21 | `class MediaControllerFactory`, `fun create` |
| [MediaMapper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/media/MediaMapper.kt) | 65 | `class MediaMapper`, `fun resolveSongFromMediaItem` |
| [ReplayGainManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/media/ReplayGainManager.kt) | 155 | `class ReplayGainManager`, `class ReplayGainValues`, `fun getCachedReplayGain`, `fun readReplayGain`, `fun gainDbToVolume`, `fun getVolumeMultiplier` |
| [SongMetadataEditor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/media/SongMetadataEditor.kt) | 1320 | `class MetadataEditError`, `interface ReplayGainUpdate`, `object Keep`, `object Clear`, `class Set`, `class SongMetadataEditor` |
| [TagBpmReader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/media/TagBpmReader.kt) | 181 | `object TagBpmReader`, `fun readBpm`, `fun readId3v2Bpm`, `fun parseId3TextFrame`, `fun syncsafeInt`, `fun beInt` |
| [TrackBpmRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/media/TrackBpmRepository.kt) | 55 | `class TrackBpmRepository`, `object NoBpm` |

## `app/src/main/java/com/quietrays/tonarc/data/model` (20 files, 1,128 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DirectoryItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/DirectoryItem.kt) | 13 | `class DirectoryItem` |
| [FolderSource.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/FolderSource.kt) | 11 | `class FolderSource`, `fun fromStorageKey` |
| [Genre.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/Genre.kt) | 14 | `class Genre` |
| [LibraryModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/LibraryModels.kt) | 67 | `class Album`, `fun empty`, `class Artist`, `fun empty`, `class ArtistRef` |
| [LibraryTabId.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/LibraryTabId.kt) | 27 | `class LibraryTabId`, `fun fromStorageKey`, `fun String` |
| [Lyrics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/Lyrics.kt) | 33 | `class Lyrics`, `class SyncedLine`, `class SyncedWord` |
| [LyricsSourcePreference.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/LyricsSourcePreference.kt) | 32 | `class LyricsSourcePreference`, `fun fromOrdinal`, `fun fromName` |
| [MusicFolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/MusicFolder.kt) | 19 | `class MusicFolder` |
| [PlayList.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/PlayList.kt) | 32 | `class Playlist`, `class PlaylistShapeType` |
| [PlaybackQueueSnapshot.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/PlaybackQueueSnapshot.kt) | 26 | `class PlaybackQueueItemSnapshot`, `class PlaybackQueueSnapshot` |
| [PlayerInfo.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/PlayerInfo.kt) | 117 | `class QueueItem`, `class WidgetThemeColors`, `class PlayerInfo` |
| [SearchFilterType.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/SearchFilterType.kt) | 12 | `class SearchFilterType` |
| [SearchHistoryItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/SearchHistoryItem.kt) | 10 | `class SearchHistoryItem` |
| [SearchResultItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/SearchResultItem.kt) | 11 | `interface SearchResultItem`, `class SongItem`, `class AlbumItem`, `class ArtistItem`, `class PlaylistItem` |
| [SmartPlaylistRule.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/SmartPlaylistRule.kt) | 54 | `class SmartPlaylistRule`, `fun fromStorageKey`, `fun SmartPlaylistRule`, `fun SmartPlaylistRule`, `fun isSmartPlaylistSource` |
| [SmartPlaylistType.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/SmartPlaylistType.kt) | 16 | `class SmartPlaylistType` |
| [Song.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/Song.kt) | 95 | `class Song`, `fun emptySong` |
| [SortOption.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/SortOption.kt) | 444 | `class SortDirection`, `class SortOption`, `object SongDefaultOrder`, `object SongTitleAZ`, `object SongTitleZA`, `object SongArtist` |
| [StorageFilter.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/StorageFilter.kt) | 10 | `class StorageFilter` |
| [Transition.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/model/Transition.kt) | 85 | `class TransitionMode`, `class Curve`, `class TransitionSource`, `class TransitionSettings`, `class TransitionResolution`, `class TransitionRule` |

## `app/src/main/java/com/quietrays/tonarc/data/musicbrainz` (2 files, 262 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MusicBrainzApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/musicbrainz/MusicBrainzApiService.kt) | 223 | `class MusicBrainzMatch`, `class MusicBrainzApiService`, `fun buildRecordingQuery`, `fun escapeLucene`, `fun parseSearchResponse`, `fun artistCreditName` |
| [MusicBrainzRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/musicbrainz/MusicBrainzRepository.kt) | 39 | `class MusicBrainzRepository` |

## `app/src/main/java/com/quietrays/tonarc/data/navidrome` (2 files, 1,136 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/navidrome/NavidromeRepository.kt) | 1059 | `class NavidromeRepository`, `fun createEncryptedPrefs`, `fun createCredentialPrefs`, `fun initFromSavedCredentials`, `fun getPlaylists`, `fun getPlaylistSongs` |
| [NavidromeStreamProxy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/navidrome/NavidromeStreamProxy.kt) | 77 | `class NavidromeStreamProxy`, `fun resolveNavidromeUri` |

## `app/src/main/java/com/quietrays/tonarc/data/navidrome/model` (7 files, 370 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeAlbum.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/navidrome/model/NavidromeAlbum.kt) | 51 | `class NavidromeAlbum`, `fun empty` |
| [NavidromeArtist.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/navidrome/model/NavidromeArtist.kt) | 36 | `class NavidromeArtist`, `fun empty` |
| [NavidromeAuthMethod.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/navidrome/model/NavidromeAuthMethod.kt) | 24 | `class NavidromeAuthMethod`, `fun fromStorageKey` |
| [NavidromeCredentials.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/navidrome/model/NavidromeCredentials.kt) | 86 | `class NavidromeCredentials`, `fun empty`, `fun connectionValidationError`, `fun isHttpAllowedHost` |
| [NavidromeMusicFolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/navidrome/model/NavidromeMusicFolder.kt) | 27 | `class NavidromeMusicFolder`, `fun empty` |
| [NavidromePlaylist.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/navidrome/model/NavidromePlaylist.kt) | 51 | `class NavidromePlaylist`, `fun empty` |
| [NavidromeSong.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/navidrome/model/NavidromeSong.kt) | 95 | `class NavidromeSong`, `fun empty` |

## `app/src/main/java/com/quietrays/tonarc/data/network/deezer` (2 files, 50 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DeezerApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/deezer/DeezerApiService.kt) | 23 | `interface DeezerApiService` |
| [DeezerModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/deezer/DeezerModels.kt) | 27 | `class DeezerSearchResponse`, `class DeezerArtist` |

## `app/src/main/java/com/quietrays/tonarc/data/network/jellyfin` (2 files, 528 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/jellyfin/JellyfinApiService.kt) | 349 | `class JellyfinApiService`, `fun setCredentials`, `fun clearCredentials`, `fun hasCredentials`, `fun getServerUrl`, `fun getAuthorizationHeader` |
| [JellyfinResponseParser.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/jellyfin/JellyfinResponseParser.kt) | 179 | `object JellyfinResponseParser`, `fun parseSong`, `fun parseSongs`, `fun parseAlbum`, `fun parseAlbums`, `fun parseArtist` |

## `app/src/main/java/com/quietrays/tonarc/data/network/lyrics` (2 files, 60 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LrcLibApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/lyrics/LrcLibApiService.kt) | 43 | `interface LrcLibApiService` |
| [LrcLibResponse.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/lyrics/LrcLibResponse.kt) | 17 | `class LrcLibResponse` |

## `app/src/main/java/com/quietrays/tonarc/data/network/navidrome` (2 files, 885 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/navidrome/NavidromeApiService.kt) | 641 | `class NavidromeApiService`, `fun setCredentials`, `fun clearCredentials`, `fun hasCredentials`, `fun getServerUrl`, `fun buildApiUrl` |
| [NavidromeResponseParser.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/navidrome/NavidromeResponseParser.kt) | 244 | `object NavidromeResponseParser`, `fun parseMusicFolder`, `fun parseMusicFolders`, `fun parseArtist`, `fun parseArtists`, `fun parseAlbum` |

## `app/src/main/java/com/quietrays/tonarc/data/network/youtube` (5 files, 1,720 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [InnertubeApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/youtube/InnertubeApiService.kt) | 484 | `class InnertubeApiService`, `fun extractCookieValue`, `fun extractVisitorData`, `fun generateSapisidHash`, `fun createBaseContext`, `fun createAndroidContext` |
| [InnertubeModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/youtube/InnertubeModels.kt) | 82 | `class InnertubeTrack`, `class InnertubeAlbum`, `class InnertubeArtist`, `class InnertubePlaylist`, `class InnertubeStreamFormat`, `class InnertubeStreamInfo` |
| [InnertubeParser.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/youtube/InnertubeParser.kt) | 1024 | `object InnertubeParser`, `fun parsePlayerResponse`, `fun parseSearchResults`, `fun extractContinuationToken`, `fun isBulletOrSeparator`, `fun isTypeOrMetadataBadge` |
| [NewPipeDownloader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/youtube/NewPipeDownloader.kt) | 50 | `class NewPipeDownloader` |
| [YouTubeExtractorManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/network/youtube/YouTubeExtractorManager.kt) | 80 | `class YouTubeExtractorManager`, `fun ensureInitialized` |

## `app/src/main/java/com/quietrays/tonarc/data/observer` (1 files, 87 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MediaStoreObserver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/observer/MediaStoreObserver.kt) | 87 | `class MediaStoreObserver`, `fun register`, `fun unregister`, `fun forceRescan` |

## `app/src/main/java/com/quietrays/tonarc/data/offline` (1 files, 310 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudOfflineRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/offline/CloudOfflineRepository.kt) | 310 | `class OfflineDownloadStatus`, `fun fromStorage`, `class OfflineDownload`, `class CloudOfflineRepository`, `fun observe`, `fun observe` |

## `app/src/main/java/com/quietrays/tonarc/data/paging` (1 files, 166 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MediaStorePagingSource.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/paging/MediaStorePagingSource.kt) | 166 | `class MediaStorePagingSource`, `fun fetchSongDetails` |

## `app/src/main/java/com/quietrays/tonarc/data/playlist` (3 files, 314 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [M3uManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/M3uManager.kt) | 73 | `class M3uManager`, `fun generateM3u` |
| [NlpPlaylistGenerator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/NlpPlaylistGenerator.kt) | 146 | `class NlpPlaylistGenerator` |
| [SmartPlaylistBuilder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/SmartPlaylistBuilder.kt) | 95 | `object SmartPlaylistBuilder`, `fun buildSongIds` |

## `app/src/main/java/com/quietrays/tonarc/data/playlist/nlp` (7 files, 1,688 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [GenreTaxonomy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/nlp/GenreTaxonomy.kt) | 202 | `class GenreFamily`, `object GenreTaxonomy`, `class Entry`, `fun resolve`, `fun energyOf`, `fun familyOf` |
| [LibraryIndex.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/nlp/LibraryIndex.kt) | 143 | `class IndexedSong`, `class LibraryIndex`, `fun idf`, `fun termWeight`, `fun signatureOf`, `fun build` |
| [LocalMetadataHeuristics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/nlp/LocalMetadataHeuristics.kt) | 288 | `object LocalMetadataHeuristics`, `fun completeMetadata`, `fun inferGenre`, `fun generateTags`, `fun genreTextureTags`, `fun analyzeMood` |
| [MoodProfile.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/nlp/MoodProfile.kt) | 254 | `class MoodKind`, `class MoodProfile`, `fun matches`, `fun matchStrength`, `fun matchesGenre` |
| [NlpLexicon.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/nlp/NlpLexicon.kt) | 65 | `object NlpLexicon`, `fun isStopWord`, `fun isNegationCue` |
| [NlpText.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/nlp/NlpText.kt) | 95 | `object NlpText`, `fun normalize`, `fun tokenize`, `fun stemTokens`, `fun stem` |
| [PlaylistIntentEngine.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/playlist/nlp/PlaylistIntentEngine.kt) | 641 | `class SongVibe`, `object PlaylistIntentEngine`, `class ParsedQuery`, `fun parse`, `fun resolveSeedArtist`, `fun generate` |

## `app/src/main/java/com/quietrays/tonarc/data/preferences` (15 files, 2,671 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtColorAccuracy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/AlbumArtColorAccuracy.kt) | 10 | `object AlbumArtColorAccuracy`, `fun clamp` |
| [AlbumArtPaletteStyle.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/AlbumArtPaletteStyle.kt) | 19 | `class AlbumArtPaletteStyle`, `fun fromStorageKey` |
| [AppLanguage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/AppLanguage.kt) | 45 | `class AppLanguage`, `fun getLanguageOptions`, `fun normalize` |
| [CarouselStyle.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/CarouselStyle.kt) | 7 | `object CarouselStyle` |
| [CollagePattern.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/CollagePattern.kt) | 20 | `class CollagePattern`, `fun fromStorageKey` |
| [EqualizerPreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/EqualizerPreferencesRepository.kt) | 276 | `class EqualizerPreferencesRepository`, `object Keys` |
| [FullPlayerLoadingTweaks.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/FullPlayerLoadingTweaks.kt) | 15 | `class FullPlayerLoadingTweaks` |
| [LaunchTab.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/LaunchTab.kt) | 7 | `object LaunchTab` |
| [LibraryNavigationMode.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/LibraryNavigationMode.kt) | 6 | `object LibraryNavigationMode` |
| [ListenBrainzPreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/ListenBrainzPreferencesRepository.kt) | 53 | `class ListenBrainzPreferencesRepository`, `object Keys` |
| [NavBarStyle.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/NavBarStyle.kt) | 6 | `object NavBarStyle` |
| [PlaylistPreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/PlaylistPreferencesRepository.kt) | 210 | `class PlaylistPreferencesRepository` |
| [PreferenceBackupEntry.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/PreferenceBackupEntry.kt) | 14 | `class PreferenceBackupEntry` |
| [ThemePreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/ThemePreferencesRepository.kt) | 74 | `class ThemePreferencesRepository`, `object Keys` |
| [UserPreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/preferences/UserPreferencesRepository.kt) | 1909 | `object ThemePreference`, `object AppThemeMode`, `fun sanitizeNavBarCornerRadius`, `class AlbumArtQuality`, `class AdvancedPerformanceDiagnosticsSettings`, `fun isActive` |

## `app/src/main/java/com/quietrays/tonarc/data/provider` (1 files, 236 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SharedArtworkContentProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/provider/SharedArtworkContentProvider.kt) | 236 | `class SharedArtworkContentProvider`, `fun resolveArtworkFile`, `fun openCloudArtworkPipe`, `fun authority`, `fun buildSongUri`, `fun buildSongUri` |

## `app/src/main/java/com/quietrays/tonarc/data/recommendation` (5 files, 560 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AdaptiveWeightTuner.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/recommendation/AdaptiveWeightTuner.kt) | 62 | `class AdaptiveWeightTuner`, `fun computeTunedWeights` |
| [CandidateAggregator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/recommendation/CandidateAggregator.kt) | 205 | `class CandidateAggregator`, `fun deduplicateCandidates`, `fun normalizeKey` |
| [ItemEmbeddingStore.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/recommendation/ItemEmbeddingStore.kt) | 79 | `class ItemEmbeddingStore` |
| [PersonalizedRanker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/recommendation/PersonalizedRanker.kt) | 191 | `class PersonalizedRanker`, `class RecommendationMood`, `class RankingWeights`, `class ScoredCandidate`, `class DiversityState`, `fun artistKey` |
| [RecommendationCandidate.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/recommendation/RecommendationCandidate.kt) | 23 | `class CandidateSourceType`, `class RecommendationCandidate` |

## `app/src/main/java/com/quietrays/tonarc/data/repository` (13 files, 4,655 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ArtistImageRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/ArtistImageRepository.kt) | 381 | `class ArtistImageRepository`, `fun calculateCustomImageSampleSize`, `fun clearCache`, `fun decodeCustomArtistBitmap`, `fun scaleBitmapIfNeeded`, `fun upgradeToHighResDeezerUrl` |
| [AudioBookmarkRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/AudioBookmarkRepository.kt) | 12 | `interface AudioBookmarkRepository`, `fun getAllBookmarksFlow` |
| [AudioBookmarkRepositoryImpl.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/AudioBookmarkRepositoryImpl.kt) | 27 | `class AudioBookmarkRepositoryImpl` |
| [FolderTreeBuilder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/FolderTreeBuilder.kt) | 274 | `class FolderTreeBuilder`, `fun buildFolderTree`, `fun buildFolderTreeForRoots`, `fun buildFolderTreeForRoot`, `fun inferRemovableStorageRoots`, `fun inferStorageRootFromPath` |
| [LyricsRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/LyricsRepository.kt) | 73 | `interface LyricsRepository`, `fun clearCache` |
| [LyricsRepositoryImpl.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/LyricsRepositoryImpl.kt) | 1647 | `fun Lyrics`, `fun parseBestEmbeddedLyricsField`, `class LyricsData`, `fun hasLyrics`, `class RemoteSearchStrategy`, `class RemoteSearchBatch` |
| [MediaStoreSongRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/MediaStoreSongRepository.kt) | 553 | `class SearchPrefs`, `class MediaStoreSongRepository`, `fun normalizePath`, `fun observeSongs`, `fun getSongIdToGenreMap` |
| [MusicRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/MusicRepository.kt) | 346 | `interface MusicRepository`, `fun getAudioFiles`, `fun getPaginatedSongs`, `fun getPaginatedAlbums`, `fun getPaginatedArtists`, `fun getPaginatedFavoriteSongs` |
| [MusicRepositoryImpl.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/MusicRepositoryImpl.kt) | 1007 | `class MusicRepositoryImpl`, `fun normalizePath`, `class CachedDirFilter`, `fun List`, `fun StorageFilter`, `fun buildGenre` |
| [SmartPlaylistGenerator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/SmartPlaylistGenerator.kt) | 132 | `class SmartPlaylistGenerator` |
| [SongRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/SongRepository.kt) | 27 | `interface SongRepository`, `fun getSongs`, `fun getSongsByAlbum`, `fun getSongsByArtist`, `fun getSongById`, `fun getPaginatedSongs` |
| [TransitionRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/TransitionRepository.kt) | 64 | `interface TransitionRepository`, `fun resolveTransitionSettings`, `fun getAllRulesForPlaylist`, `fun getPlaylistDefaultRule`, `fun getGlobalSettings` |
| [TransitionRepositoryImpl.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/repository/TransitionRepositoryImpl.kt) | 112 | `class TransitionRepositoryImpl`, `fun TransitionRuleEntity`, `fun TransitionRule` |

## `app/src/main/java/com/quietrays/tonarc/data/service` (10 files, 3,339 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CoilBitmapLoader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/CoilBitmapLoader.kt) | 67 | `class CoilBitmapLoader`, `fun loadBitmapInternal` |
| [LocalOnlyMediaNotificationProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/LocalOnlyMediaNotificationProvider.kt) | 57 | `class LocalOnlyMediaNotificationProvider`, `fun setSmallIcon` |
| [MusicNotificationProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/MusicNotificationProvider.kt) | 21 | `object MusicNotificationProvider` |
| [MusicService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/MusicService.kt) | 2525 | `fun shouldContinuePlaybackAfterTaskRemoved`, `class MusicService`, `fun markPendingMediaButtonForegroundStart`, `fun unmarkPendingMediaButtonForegroundStart`, `fun consumePendingMediaButtonForegroundStart`, `fun Player` |
| [PlaybackActivityTracker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/PlaybackActivityTracker.kt) | 28 | `object PlaybackActivityTracker`, `fun setPlaybackActive` |
| [PlaybackTimerController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/PlaybackTimerController.kt) | 279 | `interface SleepTimerAlarmScheduler`, `fun schedule`, `fun cancel`, `class AlarmManagerSleepTimerScheduler`, `fun createPendingIntent`, `class PlaybackTimerController` |
| [ReplayGainProcessor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/ReplayGainProcessor.kt) | 274 | `class ReplayGainProcessor`, `fun setEnabled`, `fun setUseAlbumGain`, `fun captureUserVolume`, `fun cancel`, `fun onPlayerVolumeChanged` |
| [SleepTimerReceiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/SleepTimerReceiver.kt) | 20 | `class SleepTimerReceiver` |
| [TonarcMediaButtonReceiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/TonarcMediaButtonReceiver.kt) | 37 | `class TonarcMediaButtonReceiver` |
| [TrustedMediaItemsResolution.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/TrustedMediaItemsResolution.kt) | 31 | `class TrustedMediaItemsResolution`, `fun resolveMediaItemsWithTrustedArtworkGrants` |

## `app/src/main/java/com/quietrays/tonarc/data/service/player` (8 files, 2,553 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AudioDecoderPolicy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/player/AudioDecoderPolicy.kt) | 50 | `object AudioDecoderPolicy`, `fun shouldUseExtensionRenderer`, `fun isLikelyHardwareDecoder` |
| [DualPlayerEngine.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/player/DualPlayerEngine.kt) | 1400 | `class ActiveDecoderInfo`, `fun shouldResumeAfterTransientAudioFocusLoss`, `fun shouldDisableAudioOffloadByDefaultForDevice`, `fun shouldTriggerAudioOffloadStallFallback`, `fun shouldDisableAudioOffloadOnEarlyBuffering`, `class DualPlayerEngine` |
| [HiFiCapabilityChecker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/player/HiFiCapabilityChecker.kt) | 68 | `object HiFiCapabilityChecker`, `fun isSupported`, `fun runCheck` |
| [HiResSampleRateCapAudioProcessor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/player/HiResSampleRateCapAudioProcessor.kt) | 271 | `class HiResSampleRateCapAudioProcessor`, `fun process16Bit`, `fun processFloat`, `fun processableFrameCount`, `fun maxPendingBytes`, `fun ensurePendingCapacity` |
| [MappingPlayer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/player/MappingPlayer.kt) | 81 | `class MappingPlayer`, `fun mapMediaItem` |
| [SmartCrossfadePlanner.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/player/SmartCrossfadePlanner.kt) | 140 | `class BpmCompatibility`, `class SmartCrossfadePlan`, `object SmartCrossfadePlanner`, `fun foldedTempoRatio`, `fun compatibility`, `fun plan` |
| [SurroundDownmixProcessor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/player/SurroundDownmixProcessor.kt) | 206 | `class SurroundDownmixProcessor`, `fun ensureOutputBuffer`, `fun downmix51Left`, `fun downmix51Right`, `fun downmix71Left`, `fun downmix71Right` |
| [TransitionController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/player/TransitionController.kt) | 337 | `class TransitionSettingsSnapshot`, `class TransitionController`, `fun initialize`, `fun scheduleTransitionFor`, `fun release` |

## `app/src/main/java/com/quietrays/tonarc/data/service/tile` (3 files, 231 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LastPlaylistTileService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/tile/LastPlaylistTileService.kt) | 163 | `class LastPlaylistTileService`, `interface LastPlaylistTileEntryPoint`, `fun musicRepository`, `fun playlistPreferencesRepository`, `fun userPreferencesRepository`, `fun findFolder` |
| [ShuffleAllTileService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/tile/ShuffleAllTileService.kt) | 41 | `class ShuffleAllTileService` |
| [TileServiceCompat.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/service/tile/TileServiceCompat.kt) | 27 | `fun TileService` |

## `app/src/main/java/com/quietrays/tonarc/data/stats` (1 files, 1,112 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [PlaybackStatsRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/stats/PlaybackStatsRepository.kt) | 1112 | `class PlaybackStatsRepository`, `class PlaybackEvent`, `class PlaybackHistoryEntry`, `class SongPlaybackSummary`, `class ArtistPlaybackSummary`, `class GenrePlaybackSummary` |

## `app/src/main/java/com/quietrays/tonarc/data/stream` (4 files, 865 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudMusicUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/stream/CloudMusicUtils.kt) | 27 | `class BulkSyncResult`, `object CloudMusicUtils`, `fun parseArtistNames` |
| [CloudStreamProxy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/stream/CloudStreamProxy.kt) | 447 | `class CloudStreamProxy`, `fun parseRouteParam`, `fun validateId`, `fun formatIdForUrl`, `class CachedUrl`, `fun isExpired` |
| [CloudStreamSecurity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/stream/CloudStreamSecurity.kt) | 196 | `object CloudStreamSecurity`, `class RangeHeaderValidation`, `fun validateNavidromeSongId`, `fun validateJellyfinItemId`, `fun validateYouTubeVideoId`, `fun validateRangeHeader` |
| [StreamDiskCache.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/stream/StreamDiskCache.kt) | 195 | `class StreamDiskCache`, `fun setMaxCacheSizeBytes`, `fun hashKey`, `fun getCachedFile`, `fun createTempFile`, `fun commitTempFile` |

## `app/src/main/java/com/quietrays/tonarc/data/worker` (11 files, 2,835 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumGroupingUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/AlbumGroupingUtils.kt) | 164 | `class AlbumGroupingKey`, `fun resolveAlbumArtist`, `fun buildAlbumGroupingKey`, `fun buildAlbumGroupingKeys`, `fun chooseAlbumDisplayArtist`, `fun resolveAlbumDisplayArtistId` |
| [ArtistParsingUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/ArtistParsingUtils.kt) | 54 | `fun collectArtistNames`, `fun choosePreferredArtistName` |
| [CloudSyncCoordinator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/CloudSyncCoordinator.kt) | 68 | `class CloudSyncCoordinator` |
| [CloudTrackDownloadWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/CloudTrackDownloadWorker.kt) | 499 | `class CloudTrackDownloadWorker`, `fun extensionFor`, `class DownloadSource`, `class DownloadHttpException`, `class StaleDownloadAttemptException` |
| [JellyfinSyncWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/JellyfinSyncWorker.kt) | 40 | `class JellyfinSyncWorker`, `fun startAllSync` |
| [NavidromeSyncWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/NavidromeSyncWorker.kt) | 83 | `class NavidromeSyncWorker`, `fun startAllSync`, `fun startPlaylistSync` |
| [RecommendationWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/RecommendationWorker.kt) | 77 | `class RecommendationWorker`, `fun periodicWork` |
| [ScrobbleFlushWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/ScrobbleFlushWorker.kt) | 121 | `class ScrobbleFlushWorker`, `fun request` |
| [SyncExecutionPlan.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/SyncExecutionPlan.kt) | 60 | `class LocalScanMode`, `class SyncExecutionPlan`, `fun buildSyncExecutionPlan`, `fun incrementalFetchTimestampSeconds` |
| [SyncManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/SyncManager.kt) | 433 | `class SyncProgress`, `class SyncPhase`, `class SyncManager`, `fun start`, `fun schedulePeriodicMaintenance`, `fun sync` |
| [SyncWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/worker/SyncWorker.kt) | 1236 | `class SyncMode`, `class SyncWorker`, `fun hasMediaReadPermission`, `class MultiArtistProcessResult`, `fun preProcessAndDeduplicateWithMultiArtist`, `class RawSongData` |

## `app/src/main/java/com/quietrays/tonarc/data/youtube` (2 files, 576 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [YouTubeRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/youtube/YouTubeRepository.kt) | 439 | `class YouTubeRepository`, `class YouTubePageResult`, `class YouTubeMultiPageResult`, `class HomeRecommendations`, `fun searchSongs`, `fun getCharts` |
| [YouTubeStreamProxy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/data/youtube/YouTubeStreamProxy.kt) | 137 | `class YouTubeStreamProxy`, `fun resolveYouTubeUri` |

## `app/src/main/java/com/quietrays/tonarc/di` (5 files, 756 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AppModule.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/di/AppModule.kt) | 531 | `object AppModule`, `fun provideApplication`, `fun provideGson`, `fun provideSessionToken`, `fun providePreferencesDataStore`, `fun provideJson` |
| [BackupModule.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/di/BackupModule.kt) | 74 | `object BackupModule`, `fun provideBackupGson`, `fun provideBackupFormatDetector`, `fun provideModuleHandlers` |
| [DispatcherProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/di/DispatcherProvider.kt) | 37 | `interface DispatcherProvider`, `class DefaultDispatcherProvider`, `class DispatcherModule`, `fun bindDispatcherProvider` |
| [NetworkModule.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/di/NetworkModule.kt) | 68 | `object NetworkModule`, `fun provideListenBrainzRetrofit`, `fun provideListenBrainzApiService`, `fun provideListenBrainzLabsRetrofit`, `fun provideListenBrainzLabsApiService` |
| [Qualifiers.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/di/Qualifiers.kt) | 46 | - |

## `app/src/main/java/com/quietrays/tonarc/presentation/components` (70 files, 26,589 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtCollage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/AlbumArtCollage.kt) | 145 | `class Config`, `fun AlbumArtCollage` |
| [AlbumCarouselSelection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/AlbumCarouselSelection.kt) | 201 | `fun rememberRoundedParallaxCarouselState`, `fun AlbumCarouselSection`, `fun resolveCurrentQueueIndex`, `fun buildQueueOccurrenceKeys` |
| [AlbumMultiSelectionOptionSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/AlbumMultiSelectionOptionSheet.kt) | 265 | `fun AlbumMultiSelectionOptionSheet`, `fun AlbumSelectionActionButton`, `fun StackedAlbumCovers` |
| [AllFilesAccessDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/AllFilesAccessDialog.kt) | 31 | `fun AllFilesAccessDialog` |
| [AppRebrandDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/AppRebrandDialog.kt) | 67 | `fun AppRebrandDialog` |
| [AppSidebarDrawer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/AppSidebarDrawer.kt) | 191 | `class DrawerDestination`, `object Home`, `object Equalizer`, `object Settings`, `fun AppSidebarDrawer`, `fun DrawerContent` |
| [BackupModuleSelectionDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/BackupModuleSelectionDialog.kt) | 568 | `fun BackupModuleSelectionDialog`, `fun closeDialog`, `fun BackupSectionSelectableCardShared` |
| [BetaInfoBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/BetaInfoBottomSheet.kt) | 694 | `fun BetaInfoBottomSheet`, `fun GitHubReportCard`, `fun BetaFaqSection`, `fun BetaCardSurface`, `fun BetaSubsectionHeader`, `fun BetaBulletList` |
| [ChangelogBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ChangelogBottomSheet.kt) | 314 | `class ChangelogSection`, `class ChangelogVersion`, `fun changelogVersions`, `fun ChangelogBottomSheet`, `fun ChangelogVersionItem`, `fun ChangelogCategory` |
| [CloudLibraryPickerSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/CloudLibraryPickerSheet.kt) | 254 | `class CloudLibraryPickerItem`, `fun CloudLibraryPickerSheet`, `fun CloudLibrarySelectorChoice` |
| [CollagePatterns.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/CollagePatterns.kt) | 68 | `fun buildCollageConfigs`, `fun cosmicSwirlConfigs`, `fun honeycombGrooveConfigs`, `fun vinylStackConfigs`, `fun pixelMosaicConfigs`, `fun stardustScatterConfigs` |
| [CollapsibleCommonTopBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/CollapsibleCommonTopBar.kt) | 136 | `fun CollapsibleCommonTopBar` |
| [CrashReportDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/CrashReportDialog.kt) | 199 | `fun CrashReportDialog` |
| [CustomPresetsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/CustomPresetsSheet.kt) | 182 | `fun CustomPresetsSheet`, `fun CustomPresetItem` |
| [DailyMixSection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/DailyMixSection.kt) | 439 | `fun DailyMixSection`, `fun DailyMixCard`, `fun DailyMixHeader`, `fun shapeConditionalModifier`, `fun threeShapeSwitch`, `fun DailyMixSongList` |
| [DismissUndoBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/DismissUndoBar.kt) | 127 | `fun DismissUndoBar` |
| [EditMultipleSongsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/EditMultipleSongsSheet.kt) | 649 | `class MixedValueField`, `fun EditMultipleSongsSheet`, `fun EditMultipleSongsContent`, `fun BatchEditField`, `fun BatchCoverArtEditorCard` |
| [EditSongSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/EditSongSheet.kt) | 1123 | `fun formatReplayGainForInput`, `fun EditSongSheet`, `fun EditSongContent`, `fun CoverArtEditorCard`, `class CoverArtCropResult`, `fun CoverArtCropperDialog` |
| [ExpressiveScrollBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ExpressiveScrollBar.kt) | 738 | `class ScrollMetrics`, `class VisibleGridLineMetrics`, `fun estimateListFallbackStridePx`, `fun observeListLayoutMetrics`, `fun buildVisibleGridLines`, `fun estimateGridFallbackStridePx` |
| [ExpressiveScrollBarLabelResolvers.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ExpressiveScrollBarLabelResolvers.kt) | 52 | `fun songFastScrollLabel`, `fun albumFastScrollLabel`, `fun artistFastScrollLabel`, `fun playlistFastScrollLabel` |
| [ExpressiveScrollBarMetrics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ExpressiveScrollBarMetrics.kt) | 147 | `class AxisObservationTracker`, `fun resetIfNeeded`, `fun observeRepresentativeSample`, `fun observeItemSize`, `fun observeStride`, `fun representativeStridePx` |
| [ExpressiveTopBarContent.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ExpressiveTopBarContent.kt) | 198 | `fun ExpressiveTopBarContent`, `fun rememberRoundedFlexFontFamily` |
| [FileExplorerBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/FileExplorerBottomSheet.kt) | 805 | `fun FileExplorerDialog`, `fun FileExplorerContent`, `fun ExplorerEmptyState`, `fun ExplorerLoadingState`, `fun FileExplorerItem`, `fun FileExplorerHeader` |
| [GenreSortBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/GenreSortBottomSheet.kt) | 188 | `fun GenreSortBottomSheet`, `fun SortOptionCard` |
| [GradientTopBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/GradientTopBar.kt) | 197 | `fun GenreGradientTopBar`, `fun HomeGradientTopBar` |
| [HomeOptionsBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/HomeOptionsBottomSheet.kt) | 38 | `fun HomeOptionsBottomSheet` |
| [HomeSectionCarousels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/HomeSectionCarousels.kt) | 557 | `fun HomeSectionHeader`, `fun HomeSongCard`, `fun HomePlaylistCard`, `fun HorizontalSongCarouselSection`, `fun HorizontalPlaylistCarouselSection`, `fun HomeAlbumCard` |
| [ImageCropView.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ImageCropView.kt) | 120 | `fun ImageCropView` |
| [LibrarySortBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/LibrarySortBottomSheet.kt) | 445 | `fun LibrarySortBottomSheet`, `fun LibrarySheetSortDirectionCard`, `fun LibrarySheetToggleCard` |
| [LyricsFloatingToolbar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/LyricsFloatingToolbar.kt) | 162 | `fun LyricsFloatingToolbar` |
| [LyricsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/LyricsSheet.kt) | 1987 | `class LyricsSheetColors`, `fun lyricsSheetColors`, `fun preferredContrastColor`, `fun contrastRatio`, `fun Color`, `fun Color` |
| [LyricsSyncControls.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/LyricsSyncControls.kt) | 125 | `fun LyricsSyncControls`, `fun androidx` |
| [MarqueeText.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/MarqueeText.kt) | 187 | `fun AutoScrollingTextOnDemand`, `fun AutoScrollingText` |
| [MultiSelectionBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/MultiSelectionBottomSheet.kt) | 518 | `fun MultiSelectionBottomSheet`, `fun StackedAlbumArts` |
| [NoInternetComponents.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/NoInternetComponents.kt) | 116 | `fun NoInternetDialog`, `fun NoInternetScreen` |
| [OptimizedAlbumArt.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/OptimizedAlbumArt.kt) | 253 | `fun OptimizedAlbumArt`, `fun PlaceholderContent`, `fun renderDirectAlbumArt`, `fun safeAlbumArtTargetSize`, `fun albumArtMemoryCacheKey` |
| [PermissionIconCollage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/PermissionIconCollage.kt) | 102 | `class IconConfig`, `fun PermissionIconCollage` |
| [PlayerInternalNavigationBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/PlayerInternalNavigationBar.kt) | 241 | `fun sanitizeNavigationBarBottomInset`, `fun calculatePlayerSheetCollapsedTargetY`, `fun resolveNavBarContentHeight`, `fun resolveMainScreenBottomGradientHeight`, `fun resolveNavBarSurfaceHeight`, `fun resolveNavBarOccupiedHeight` |
| [PlayerNavigationRail.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/PlayerNavigationRail.kt) | 125 | `fun PlayerNavigationRail` |
| [PlaylistArtCollage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/PlaylistArtCollage.kt) | 218 | `fun PlaylistArtCollage` |
| [PlaylistBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/PlaylistBottomSheet.kt) | 246 | `fun PlaylistBottomSheet` |
| [PlaylistContainer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/PlaylistContainer.kt) | 578 | `fun PlaylistContainer`, `fun PlaylistItems`, `fun PlaylistItem`, `fun CreatePlaylistDialogRedesigned` |
| [PlaylistCover.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/PlaylistCover.kt) | 132 | `fun PlaylistCover`, `fun getIconByName` |
| [PlaylistCreationDialogs.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/PlaylistCreationDialogs.kt) | 430 | `fun PlaylistCreationTypeDialog`, `fun DescribePlaylistDialog`, `fun CreationModeCard` |
| [PlaylistMultiSelectionBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/PlaylistMultiSelectionBottomSheet.kt) | 377 | `fun PlaylistMultiSelectionBottomSheet`, `fun StackedPlaylistCovers`, `fun getPlaylistIconByName` |
| [QueueBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/QueueBottomSheet.kt) | 2088 | `class QueueUndoBarProjection`, `fun PlayerUiState`, `fun QueueBottomSheet`, `fun activeQueueIndexAt`, `fun activeKeyAt`, `fun remapCommittedKeysForDisplay` |
| [RecentlyPlayedRangeSelector.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/RecentlyPlayedRangeSelector.kt) | 169 | `fun RecentlyPlayedRangeSelector`, `fun RecentlyPlayedRangeChip` |
| [RecentlyPlayedSection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/RecentlyPlayedSection.kt) | 352 | `class RecentlyPlayedPillCell`, `class RecentlyPlayedPillRow`, `fun RecentlyPlayedSection`, `fun buildRecentlyPlayedPillRows`, `fun resolveRecentlyPlayedRowTargets`, `fun RecentlyPlayedPill` |
| [ReorderPresetsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ReorderPresetsSheet.kt) | 397 | `fun ReorderPresetsSheet`, `class PresetItem`, `fun togglePin` |
| [ReorderTabsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ReorderTabsSheet.kt) | 288 | `fun ReorderTabsSheet`, `fun FloatingToolBar` |
| [RoundedParallaxCarousell.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/RoundedParallaxCarousell.kt) | 1481 | `class CarouselState`, `fun rememberCarouselState`, `fun RoundedHorizontalMultiBrowseCarousel`, `fun RoundedCarousel`, `class CarouselPageSize`, `interface CarouselItemScope` |
| [SavePresetDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/SavePresetDialog.kt) | 144 | `fun SavePresetDialog`, `fun RenamePresetDialog` |
| [ScreenWrapper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ScreenWrapper.kt) | 133 | `fun ScreenWrapper` |
| [SheetStates.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/SheetStates.kt) | 29 | `fun rememberModalSheetState` |
| [ShimmerBox.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ShimmerBox.kt) | 45 | `fun ShimmerBox` |
| [SmartImage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/SmartImage.kt) | 265 | `fun SmartImage`, `fun handleDirectModel`, `fun Placeholder` |
| [SongInfoBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/SongInfoBottomSheet.kt) | 1321 | `fun SongInfoBottomSheet`, `fun requestToneSystemWritePermission`, `fun handleToneResult`, `fun setCurrentSongAsTone`, `fun ToneTargetPickerDialog`, `fun ToneTargetOption` |
| [SongPickerBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/SongPickerBottomSheet.kt) | 888 | `fun SongPickerBottomSheet`, `fun SongPickerContent`, `fun SongPickerSelectionPane`, `fun SongPickerSearchField`, `fun SongPickerPagingList`, `fun SongPickerRow` |
| [StatsOverviewCard.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/StatsOverviewCard.kt) | 325 | `fun StatsOverviewCard`, `fun OverviewContent`, `fun PlaceholderOverviewContent`, `fun MiniListeningTimeline`, `fun MonthlyHorizontalListeningTimeline`, `fun PlaceholderLine` |
| [StreamingProviderSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/StreamingProviderSheet.kt) | 242 | `fun StreamingProviderSheet`, `fun ProviderRow` |
| [SyncProgressBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/SyncProgressBar.kt) | 193 | `fun SyncProgressBar`, `fun getPhaseText`, `fun CompactSyncProgressIndicator` |
| [TimerOptionsBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/TimerOptionsBottomSheet.kt) | 443 | `fun TimerOptionsBottomSheet` |
| [ToggleSegmentButton.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/ToggleSegmentButton.kt) | 219 | `fun ToggleSegmentButton`, `fun ToggleSegmentButton`, `fun ToggleSegmentButton`, `fun ToggleSegmentButton`, `fun ToggleSegmentButtonContainer` |
| [UnifiedPlayerOverlaysLayer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/UnifiedPlayerOverlaysLayer.kt) | 454 | `class SaveQueueOverlayData`, `fun UnifiedPlayerQueueLayer`, `fun UnifiedPlayerSongInfoLayer`, `fun UnifiedPlayerQueueAndSongInfoHost`, `fun UnifiedPlayerSaveQueueLayer` |
| [UnifiedPlayerSheetLayers.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/UnifiedPlayerSheetLayers.kt) | 321 | `fun BoxScope`, `fun UnifiedPlayerPrewarmLayer` |
| [UnifiedPlayerSheetShared.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/UnifiedPlayerSheetShared.kt) | 225 | `fun getNavigationBarHeight`, `fun MiniPlayerContentInternal` |
| [UnifiedPlayerSheetV2.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/UnifiedPlayerSheetV2.kt) | 723 | `class PlayerUiSheetSliceV2`, `fun UnifiedPlayerSheetV2` |
| [WavyArcSlider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/WavyArcSlider.kt) | 207 | `fun WavyArcSlider`, `fun mapTouchToValue`, `fun dispatchValue` |
| [WavyMusicSlider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/WavyMusicSlider.kt) | 338 | `fun WavyMusicSlider`, `fun yAt` |
| [WavySliderExpressive.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/WavySliderExpressive.kt) | 364 | `fun normalizeValue`, `fun WavySliderExpressive`, `fun lerp`, `fun valueForX` |

## `app/src/main/java/com/quietrays/tonarc/presentation/components/brickbreaker` (1 files, 999 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BrickBreakerOverlay.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/brickbreaker/BrickBreakerOverlay.kt) | 999 | `class BrickType`, `class BrickState`, `class Particle`, `fun BrickBreakerOverlay`, `fun centerPaddle`, `fun attachBallToPaddle` |

## `app/src/main/java/com/quietrays/tonarc/presentation/components/external` (1 files, 371 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExternalPlayerOverlay.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/external/ExternalPlayerOverlay.kt) | 371 | `fun ExternalPlayerOverlay` |

## `app/src/main/java/com/quietrays/tonarc/presentation/components/player` (6 files, 3,484 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AddBookmarkDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/player/AddBookmarkDialog.kt) | 262 | `fun AddBookmarkDialog`, `fun resolveLyricBookmarkTitle` |
| [AnimatedPlaybackControls.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/player/AnimatedPlaybackControls.kt) | 223 | `class PlaybackButtonType`, `fun AnimatedPlaybackControls`, `fun weightFor` |
| [BottomToggleRow.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/player/BottomToggleRow.kt) | 121 | `fun BottomToggleRow` |
| [FullPlayerContent.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/player/FullPlayerContent.kt) | 2496 | `class SkipDirection`, `fun FullPlayerContent`, `fun predictSkipCarouselIndex`, `fun requestSkip`, `fun FullPlayerAlbumCoverSection`, `fun FullPlayerControlsSection` |
| [MorphingPlayPauseIcon.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/player/MorphingPlayPauseIcon.kt) | 97 | `fun quad`, `fun MorphingPlayPauseIcon` |
| [PlayerArtistPickerBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/player/PlayerArtistPickerBottomSheet.kt) | 285 | `class PlayerArtistShortcutItem`, `fun PlayerArtistPickerBottomSheet`, `fun PlayerArtistShortcutCard`, `fun artistShortcutShape` |

## `app/src/main/java/com/quietrays/tonarc/presentation/components/scoped` (28 files, 2,852 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ComposeLoader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/ComposeLoader.kt) | 109 | `fun DeferAt`, `fun DeferUntil`, `fun rememberSmoothProgress`, `fun sampleNow` |
| [CustomNavigationBarItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/CustomNavigationBarItem.kt) | 194 | `fun RowScope` |
| [Expansion.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/Expansion.kt) | 9 | `fun rememberExpansionTransition` |
| [FullPlayerCompositionPolicy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/FullPlayerCompositionPolicy.kt) | 73 | `class FullPlayerCompositionPolicy`, `fun rememberFullPlayerCompositionPolicy` |
| [FullPlayerRuntimePolicy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/FullPlayerRuntimePolicy.kt) | 48 | `class FullPlayerRuntimePolicy`, `fun rememberFullPlayerRuntimePolicy` |
| [FullPlayerVisualState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/FullPlayerVisualState.kt) | 41 | `class FullPlayerVisualState`, `fun rememberFullPlayerVisualState` |
| [KeylineListScope.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/KeylineListScope.kt) | 2 | - |
| [LyricsPredictiveBackHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/LyricsPredictiveBackHandler.kt) | 51 | `fun LyricsPredictiveBackHandler` |
| [MiniPlayerDismissGestureHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/MiniPlayerDismissGestureHandler.kt) | 177 | `class MiniDismissDragPhase`, `class MiniPlayerDismissGestureHandler`, `fun onDragStart`, `fun onHorizontalDrag`, `fun onDragEnd`, `fun rememberMiniPlayerDismissGestureHandler` |
| [PlayerAlbumNavigationEffect.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/PlayerAlbumNavigationEffect.kt) | 32 | `fun PlayerAlbumNavigationEffect` |
| [PlayerArtistNavigationEffect.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/PlayerArtistNavigationEffect.kt) | 33 | `fun PlayerArtistNavigationEffect` |
| [PlayerSheetPredictiveBackHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/PlayerSheetPredictiveBackHandler.kt) | 79 | `fun PlayerSheetPredictiveBackHandler` |
| [PrefetchAlbumNeighbors.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/PrefetchAlbumNeighbors.kt) | 103 | `fun PrefetchAlbumNeighborsImg`, `fun PrefetchAlbumNeighbors` |
| [PrewarmFullPlayerState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/PrewarmFullPlayerState.kt) | 40 | `fun rememberPrewarmFullPlayer` |
| [QueueItemDismissGestureHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/QueueItemDismissGestureHandler.kt) | 213 | `class QueueDismissDragPhase`, `class QueueItemDismissGestureHandler`, `fun onDragStart`, `fun onHorizontalDrag`, `fun onDragEnd`, `fun onDragCancel` |
| [QueueSheetController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/QueueSheetController.kt) | 179 | `class QueueSheetController`, `fun resetDragPipeline`, `fun launchDragSnapLoopIfNeeded`, `fun animate`, `fun beginDrag`, `fun dragBy` |
| [QueueSheetRuntimeEffects.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/QueueSheetRuntimeEffects.kt) | 52 | `fun QueueSheetRuntimeEffects` |
| [QueueSheetState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/QueueSheetState.kt) | 97 | `class QueueSheetState`, `fun rememberQueueSheetState` |
| [SheetActionHandlers.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetActionHandlers.kt) | 139 | `class SheetActionHandlers`, `fun rememberSheetActionHandlers` |
| [SheetBackAndDragState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetBackAndDragState.kt) | 56 | `class SheetBackAndDragState`, `fun rememberSheetBackAndDragState` |
| [SheetInteractionState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetInteractionState.kt) | 165 | `class SheetInteractionState`, `fun rememberSheetInteractionState`, `class PlayerSheetDynamicShape`, `fun Dp` |
| [SheetModalOverlayController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetModalOverlayController.kt) | 74 | `class SheetModalOverlayController`, `fun updateSelectedSongForInfo`, `fun dismissSaveQueueOverlay`, `fun launchSaveQueueOverlay`, `fun rememberSheetModalOverlayController` |
| [SheetMotionController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetMotionController.kt) | 87 | `class SheetMotionController` |
| [SheetOverlayState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetOverlayState.kt) | 90 | `class SheetOverlayState`, `fun rememberSheetOverlayState` |
| [SheetThemeState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetThemeState.kt) | 226 | `class SheetThemeState`, `fun resolvePlayerSheetTargetScheme`, `fun rememberSheetThemeState`, `fun rememberBatchAnimatedColorScheme`, `fun lerpColorScheme` |
| [SheetVerticalDragGestureHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetVerticalDragGestureHandler.kt) | 171 | `class SheetVerticalDragGestureHandler`, `fun onDragStart`, `fun onVerticalDrag`, `fun onDragEnd`, `fun onDragCancel`, `fun Modifier` |
| [SheetVerticalDragMath.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetVerticalDragMath.kt) | 69 | `class SheetVerticalDragFrame`, `fun computeSheetVerticalDragFrame`, `fun resolveVerticalSheetTargetState`, `fun collapseSpringDampingForFraction`, `fun collapseInitialSquashForFraction` |
| [SheetVisualState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/scoped/SheetVisualState.kt) | 243 | `class SheetVisualState`, `fun rememberSheetVisualState` |

## `app/src/main/java/com/quietrays/tonarc/presentation/components/snapping` (1 files, 400 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LazyListSnapper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/snapping/LazyListSnapper.kt) | 400 | `object SnapperFlingBehaviorDefaults`, `class SnapperLayoutInfo`, `fun determineTargetIndex`, `fun distanceToIndexSnap`, `fun canScrollTowardsStart`, `fun canScrollTowardsEnd` |

## `app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps` (15 files, 3,461 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AutoSizingText.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/AutoSizingText.kt) | 149 | `fun AutoSizingTextToFill` |
| [AutoSizingTextGlance.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/AutoSizingTextGlance.kt) | 129 | `fun AutoSizingTextGlance` |
| [EnhancedSongListItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/EnhancedSongListItem.kt) | 409 | `class EnhancedSongAnimationTarget`, `fun lerpFloat`, `fun EnhancedSongListItem` |
| [ExpressiveSongListItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/ExpressiveSongListItem.kt) | 113 | `fun ExpressiveSongListItem` |
| [FetchLyricsDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/FetchLyricsDialog.kt) | 595 | `fun FetchLyricsDialog`, `fun IdleContent`, `fun LoadingContent`, `fun PickResultContent`, `fun ResultItemCard`, `fun NotFoundContent` |
| [LibraryActionRow.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/LibraryActionRow.kt) | 506 | `fun LibraryActionRow`, `fun Breadcrumbs` |
| [LyricsMoreBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/LyricsMoreBottomSheet.kt) | 553 | `fun LyricsMoreBottomSheet` |
| [MaterialYouVectorDrawable.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/MaterialYouVectorDrawable.kt) | 53 | `fun MaterialYouVectorDrawable`, `fun Context` |
| [PlayerProgressBarSection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/PlayerProgressBarSection.kt) | 2 | - |
| [PlayerSeekBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/PlayerSeekBar.kt) | 126 | `fun PlayerSeekBar` |
| [PlayingEqIcon.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/PlayingEqIcon.kt) | 108 | `fun PlayingEqIcon` |
| [SelectionActionRow.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/SelectionActionRow.kt) | 236 | `fun SelectionActionRow`, `fun SelectionCountPill` |
| [SelectionHeader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/SelectionHeader.kt) | 257 | `fun SelectionHeader`, `fun StackedCoverArts` |
| [SineWaveLine.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/SineWaveLine.kt) | 111 | `fun SineWaveLine` |
| [TightWrapText.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/components/subcomps/TightWrapText.kt) | 114 | `fun TightWrapText`, `class TextLayoutContainer` |

## `app/src/main/java/com/quietrays/tonarc/presentation/jellyfin/auth` (2 files, 650 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinLoginActivity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/jellyfin/auth/JellyfinLoginActivity.kt) | 540 | `class JellyfinLoginActivity`, `fun JellyfinLoginScreen`, `fun JellyfinLoginField` |
| [JellyfinLoginViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/jellyfin/auth/JellyfinLoginViewModel.kt) | 110 | `interface JellyfinLoginState`, `object Idle`, `object Loading`, `class SelectLibraries`, `class Success`, `class Error` |

## `app/src/main/java/com/quietrays/tonarc/presentation/jellyfin/dashboard` (2 files, 977 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinDashboardScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/jellyfin/dashboard/JellyfinDashboardScreen.kt) | 818 | `fun JellyfinDashboardScreen`, `fun JellyfinDashboardContent`, `fun JellyfinMenuCard`, `fun JellyfinLibrarySummaryPanel`, `fun JellyfinLibrarySelectorSheet`, `fun JellyfinPlaylistCard` |
| [JellyfinDashboardViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/jellyfin/dashboard/JellyfinDashboardViewModel.kt) | 159 | `class JellyfinDashboardViewModel`, `fun loadLibraries`, `fun setSelectedLibraryIds`, `fun syncAllPlaylistsAndSongs`, `fun syncPlaylists`, `fun syncPlaylistSongs` |

## `app/src/main/java/com/quietrays/tonarc/presentation/model` (3 files, 319 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LibraryTabId.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/model/LibraryTabId.kt) | 110 | `class LibraryTabId`, `fun fromStableKey`, `fun decodeLibraryTabOrder` |
| [RecentlyPlayedSongUi.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/model/RecentlyPlayedSongUi.kt) | 129 | `class RecentlyPlayedSongUiModel`, `fun mapRecentlyPlayedSongs`, `fun collectRecentlyPlayedSongIds`, `fun StatsTimeRange` |
| [SettingsCategory.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/model/SettingsCategory.kt) | 80 | `class SettingsCategory`, `fun fromId` |

## `app/src/main/java/com/quietrays/tonarc/presentation/navidrome/auth` (2 files, 679 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeLoginActivity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/navidrome/auth/NavidromeLoginActivity.kt) | 570 | `class NavidromeLoginActivity`, `fun NavidromeLoginScreen`, `fun ExpressiveLoginField`, `fun Surface` |
| [NavidromeLoginViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/navidrome/auth/NavidromeLoginViewModel.kt) | 109 | `interface NavidromeLoginState`, `object Idle`, `object Loading`, `class SelectLibraries`, `class Success`, `class Error` |

## `app/src/main/java/com/quietrays/tonarc/presentation/navidrome/dashboard` (2 files, 1,212 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeDashboardScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/navidrome/dashboard/NavidromeDashboardScreen.kt) | 1034 | `fun NavidromeDashboardScreen`, `fun DashboardContent`, `fun SubsonicMenuCard`, `fun NavidromeLibrarySummaryPanel`, `fun LibrarySelectorSheet`, `fun LibrarySelectorChoice` |
| [NavidromeDashboardViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/navidrome/dashboard/NavidromeDashboardViewModel.kt) | 178 | `class NavidromeDashboardViewModel`, `fun observeSyncWorker`, `fun syncAllPlaylistsAndSongs`, `fun loadMusicFolders`, `fun setSelectedMusicFolderIds`, `fun syncPlaylistSongs` |

## `app/src/main/java/com/quietrays/tonarc/presentation/navigation` (5 files, 966 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AppNavigation.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/navigation/AppNavigation.kt) | 742 | `fun AppNavigation`, `fun String`, `class MainRootDirection`, `fun mainRootDirection`, `fun mainRootEnterTransition`, `fun mainRootExitTransition` |
| [MainRootRoutes.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/navigation/MainRootRoutes.kt) | 15 | `fun isMainRootRoute`, `fun mainRootRouteIndex` |
| [NavControllerExtensions.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/navigation/NavControllerExtensions.kt) | 59 | `fun NavController`, `fun NavController`, `fun NavController`, `fun NavController`, `fun NavController` |
| [Screen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/navigation/Screen.kt) | 92 | `class Screen`, `object Home`, `object Search`, `object Library`, `object Settings`, `object Accounts` |
| [Transitions.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/navigation/Transitions.kt) | 58 | `fun enterTransition`, `fun exitTransition`, `fun popEnterTransition`, `fun popExitTransition` |

## `app/src/main/java/com/quietrays/tonarc/presentation/screens` (40 files, 37,984 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AboutScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/AboutScreen.kt) | 1021 | `class Contributor`, `class ProjectLink`, `fun AboutScreen`, `fun AboutHeroCard`, `fun CommunitySignalsRow`, `fun AboutSupportCard` |
| [AccountsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/AccountsScreen.kt) | 1147 | `fun AccountsScreen`, `fun StatTile`, `fun ConnectedAccountCard`, `fun EmptyAccountsCard`, `class ServicePalette`, `fun servicePalette` |
| [AlbumDetailScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/AlbumDetailScreen.kt) | 867 | `fun AlbumDetailScreen`, `fun SharedAlbumTopBarProbe`, `fun CollapsingAlbumTopBar` |
| [ArtistDetailScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/ArtistDetailScreen.kt) | 1191 | `fun ArtistDetailScreen`, `fun ArtistAlbumSection`, `fun CollapsibleAlbumSectionHeader`, `fun ArtistAlbumSectionSongItem`, `fun SharedArtistTopBarProbe`, `fun CustomCollapsingTopBar` |
| [ArtistSettingsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/ArtistSettingsScreen.kt) | 525 | `fun ArtistSettingsScreen`, `fun RescanRequiredBanner`, `fun InfoCard`, `fun ExamplesCard` |
| [AudioBookmarkModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/AudioBookmarkModels.kt) | 290 | `class AudioBookmarkFolder`, `class BookmarkFolderCardPresentation`, `class BookmarkVisibleItemGeometry`, `fun bookmarkFolderCardPresentation`, `fun bookmarkFocusedItemKey`, `fun bookmarkLastFocusableIndex` |
| [AudioBookmarksScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/AudioBookmarksScreen.kt) | 2070 | `fun AudioBookmarksScreen`, `fun AudioBookmarkFolderScreen`, `fun BookmarkFolderTopBar`, `fun BookmarkFolderSectionHeader`, `fun formatBookmarkMomentCount`, `class BookmarkFolderSortMode` |
| [CloudDownloadsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/CloudDownloadsScreen.kt) | 432 | `fun CloudDownloadsScreen`, `fun OfflineDownload`, `fun StorageSummaryCard`, `fun SectionHeader`, `fun DownloadItemCard`, `fun DownloadsEmptyState` |
| [CreatePlaylistScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/CreatePlaylistScreen.kt) | 1664 | `class Quadruple`, `fun smartPlaylistRuleTitle`, `fun smartPlaylistRuleSubtitle`, `class PlaylistCreationMode`, `fun CreatePlaylistDialog`, `fun EditPlaylistDialog` |
| [DailyMixScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/DailyMixScreen.kt) | 540 | `fun DailyMixScreen`, `fun ExpressiveDailyMixHeader`, `fun rememberDailyMixTitleStyle` |
| [DelimiterConfigScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/DelimiterConfigScreen.kt) | 474 | `fun DelimiterConfigScreen`, `fun DelimiterChip` |
| [DeviceCapabilitiesScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/DeviceCapabilitiesScreen.kt) | 1502 | `fun DeviceCapabilitiesScreen`, `fun DeviceCapabilitiesContent`, `fun PerformanceReportCard`, `fun AdvancedDiagnosticsToggleRow`, `fun formatDiagnosticsExpiry`, `fun PlaybackReadinessCard` |
| [DuplicateSongsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/DuplicateSongsScreen.kt) | 151 | `fun DuplicateSongsScreen`, `fun DuplicateGroupCard` |
| [EasterEggScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/EasterEggScreen.kt) | 65 | `fun EasterEggScreen` |
| [EditTransitionScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/EditTransitionScreen.kt) | 716 | `fun EditTransitionScreen`, `fun TransitionSummaryCard`, `fun TransitionModeSection`, `fun ExpressiveMorphingToggle`, `fun TransitionDurationSection`, `fun CrossfadeVisualizer` |
| [EqualizerScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/EqualizerScreen.kt) | 1793 | `fun EqualizerScreen`, `fun PresetTabsRow`, `fun BandSlidersSection`, `fun GraphBandSliders`, `fun VerticalBandSlider`, `fun CustomVerticalSlider` |
| [ExperimentalSettingsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/ExperimentalSettingsScreen.kt) | 865 | `fun ExperimentalSettingsScreen`, `fun albumArtQualityLine`, `fun TriggerModeOptionCard` |
| [GenreDetailScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/GenreDetailScreen.kt) | 881 | `fun GenreDetailScreen`, `fun genreFastScrollLabel`, `fun GenreDetailListItem`, `fun GenreCollapsibleTopBar`, `fun GenreArtistHeader`, `fun GenreAlbumHeader` |
| [HomeScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/HomeScreen.kt) | 1104 | `class HomeFilter`, `fun HomeScreen`, `fun YourMixLoadingPlaceholder`, `fun YourMixEmptyPlaceholder`, `fun YourMixHeader`, `fun SongListItemFavs` |
| [LibraryEmptyState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/LibraryEmptyState.kt) | 230 | `class LibraryEmptySpec`, `fun libraryEmptySpec`, `fun LibraryExpressiveEmptyState` |
| [LibraryMediaTabs.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/LibraryMediaTabs.kt) | 704 | `fun LibraryAlbumsTab`, `fun LibraryArtistsTab`, `fun LibraryPlaylistsTab` |
| [LibraryPlaybackAwareSongItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/LibraryPlaybackAwareSongItem.kt) | 64 | `class LibrarySongPlaybackUiState`, `fun LibraryPlaybackAwareSongItem` |
| [LibraryScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/LibraryScreen.kt) | 3349 | `class LibraryScreenPlayerProjection`, `fun PlayerUiState`, `fun LibraryScreen`, `fun CompactLibraryPagerIndicator`, `fun LibraryInlineSyncIndicator`, `fun LibrarySyncOverlay` |
| [LibrarySongsAndFavoritesTabs.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/LibrarySongsAndFavoritesTabs.kt) | 511 | `fun LibraryFavoritesTab`, `fun LibrarySongsTabPaginated` |
| [LibrarySongsTab.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/LibrarySongsTab.kt) | 369 | `fun LibrarySongsTab` |
| [MashupScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/MashupScreen.kt) | 339 | `fun MashupScreen`, `fun DeckUi`, `fun SliderControl`, `fun Crossfader`, `fun SongPickerSheet`, `fun SongPickerItem` |
| [NavBarCornerRadiusScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/NavBarCornerRadiusScreen.kt) | 353 | `fun NavBarCornerRadiusScreen`, `fun NavBarCornerRadiusContent`, `fun Float` |
| [PaletteStyleSettingsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/PaletteStyleSettingsScreen.kt) | 750 | `fun PaletteStyleSettingsScreen`, `fun PaletteStyleHeader`, `fun MiniFullPlayerSkeletonPreview`, `fun scaled`, `fun PaletteSwatchSquare`, `fun PaletteAccuracySlider` |
| [PlaylistDetailScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/PlaylistDetailScreen.kt) | 1212 | `fun PlaylistDetailScreen`, `fun PlaylistActionItem`, `fun RenamePlaylistDialog` |
| [QuickFillScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/QuickFillScreen.kt) | 461 | `fun QuickFillDialog`, `fun QuickFillContent`, `fun GenreValidatorContent` |
| [RecentlyPlayedScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/RecentlyPlayedScreen.kt) | 768 | `fun RecentlyPlayedScreen`, `fun ExpressiveRecentlyPlayedHeader`, `fun rememberRecentlyPlayedTitleStyle`, `fun RecentlyPlayedActions`, `fun RecentlyPlayedTimestampDivider`, `fun RecentlyPlayedEmptyState` |
| [RecommendationStatsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/RecommendationStatsScreen.kt) | 479 | `fun RecommendationStatsScreen`, `fun OverviewMetricsCard`, `fun MetricItem`, `fun AdaptiveWeightsCard`, `fun WeightRow`, `fun TestingActionsCard` |
| [SearchScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/SearchScreen.kt) | 1099 | `class SearchUiSlice`, `fun SearchScreen`, `fun SearchResultSectionHeader`, `fun EmptySearchResults`, `fun SearchResultsList`, `fun SearchResultAlbumItem` |
| [SettingsCategoryScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/SettingsCategoryScreen.kt) | 2725 | `fun SettingsCategoryScreen`, `fun buildBackupSelectionSummary`, `fun backupSectionIconRes`, `fun BackupInfoNoticeCard`, `fun BackupSectionSelectionDialog`, `fun closeDialog` |
| [SettingsComponents.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/SettingsComponents.kt) | 718 | `fun SettingsSection`, `fun SettingsItem`, `fun SwitchSettingItem`, `fun ThemeSelectorItem`, `fun ExpressiveSettingsGroup`, `fun SliderSettingsItem` |
| [SettingsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/SettingsScreen.kt) | 664 | `fun SettingsScreen`, `fun shapeFor`, `fun ExpressiveNavigationItem`, `fun ExpressiveCategoryItem`, `fun getAccountsColors`, `fun getDownloadsColors` |
| [SetupScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/SetupScreen.kt) | 2729 | `fun SetupScreen`, `fun DirectorySelectionPage`, `class SetupPage`, `object Welcome`, `object MediaPermission`, `object BackupRestore` |
| [StatsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/StatsScreen.kt) | 2607 | `fun StatsScreen`, `fun StatsHeroSection`, `fun HeroCard`, `fun StatsEmptyState`, `fun SummaryPill`, `fun SummaryHeroTile` |
| [TabAnimation.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/TabAnimation.kt) | 121 | `fun TabAnimation` |
| [WordDelimiterConfigScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/WordDelimiterConfigScreen.kt) | 434 | `fun WordDelimiterConfigScreen` |

## `app/src/main/java/com/quietrays/tonarc/presentation/screens/search/components` (3 files, 1,039 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [GenreCategoriesGrid.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/search/components/GenreCategoriesGrid.kt) | 360 | `fun GenreCategoriesGrid`, `fun GenreCard` |
| [GenreTypography.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/search/components/GenreTypography.kt) | 415 | `object GenreTypography`, `class TitlePresentation`, `fun resolveTitlePresentation`, `fun getGenreStyle`, `fun fitsSingleLine`, `fun findBestBreak` |
| [GenreiconProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/screens/search/components/GenreiconProvider.kt) | 264 | `fun getGenreImageResource`, `fun splitGenreParts`, `fun keywordFallback`, `fun normalizeGenreKey`, `object GenreMapBuilder`, `fun build` |

## `app/src/main/java/com/quietrays/tonarc/presentation/settings/search` (5 files, 1,237 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SettingHighlightModifier.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/settings/search/SettingHighlightModifier.kt) | 59 | `fun Modifier` |
| [SettingSpec.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/settings/search/SettingSpec.kt) | 58 | `class SettingType`, `class SettingSpec`, `fun getTitle`, `fun getSubtitle`, `fun createNavigationRoute`, `class SearchResultItem` |
| [SettingsFuzzySearchEngine.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/settings/search/SettingsFuzzySearchEngine.kt) | 199 | `object SettingsFuzzySearchEngine`, `fun search`, `fun calculateScore`, `fun normalize`, `fun similarity`, `fun levenshteinDistance` |
| [SettingsRegistry.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/settings/search/SettingsRegistry.kt) | 600 | `object SettingsRegistry` |
| [SettingsSearchComponents.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/settings/search/SettingsSearchComponents.kt) | 321 | `fun SettingsSearchResultsContent`, `fun SearchResultSwitchItem`, `fun SearchResultNavigableItem` |

## `app/src/main/java/com/quietrays/tonarc/presentation/stats` (1 files, 14 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [StatsTimeRangeUi.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/stats/StatsTimeRangeUi.kt) | 14 | `fun StatsTimeRange` |

## `app/src/main/java/com/quietrays/tonarc/presentation/utils` (2 files, 664 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AppHaptics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/utils/AppHaptics.kt) | 39 | `class AppHapticsConfig`, `fun View`, `fun performAppCompatHapticFeedback` |
| [GenreIconProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/utils/GenreIconProvider.kt) | 625 | `object GenreIconProvider`, `fun getGenreImageResource` |

## `app/src/main/java/com/quietrays/tonarc/presentation/viewmodel` (47 files, 18,071 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AccountsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/AccountsViewModel.kt) | 338 | `class ExternalServiceAccount`, `class ExternalAccountUiModel`, `class ListenBrainzUiModel`, `interface ListenBrainzStatsUiState`, `object Loading`, `object Unavailable` |
| [AlbumDetailViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/AlbumDetailViewModel.kt) | 151 | `class AlbumDetailUiState`, `class AlbumDetailViewModel`, `fun loadAlbumData`, `fun retry`, `fun update`, `fun downloadAlbum` |
| [ArtistDetailViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/ArtistDetailViewModel.kt) | 326 | `class ArtistDetailUiState`, `class ArtistAlbumSection`, `class ArtistDetailViewModel`, `fun loadArtistData`, `fun retry`, `fun setCustomImage` |
| [ArtistSettingsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/ArtistSettingsViewModel.kt) | 157 | `class ArtistSettingsUiState`, `class ArtistSettingsViewModel`, `fun setGroupByAlbumArtist`, `fun setArtistDelimiters`, `fun addDelimiter`, `fun removeDelimiter` |
| [AudioBookmarksViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/AudioBookmarksViewModel.kt) | 63 | `class AudioBookmarksViewModel`, `fun observeSongs`, `fun addBookmark`, `fun deleteBookmark`, `fun renameBookmark` |
| [CloudDownloadsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/CloudDownloadsViewModel.kt) | 79 | `class CloudDownloadsUiState`, `fun List`, `class CloudDownloadsViewModel`, `fun remove`, `fun retry`, `fun downloadSelected` |
| [ColorSchemePair.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/ColorSchemePair.kt) | 8 | `class ColorSchemePair` |
| [ColorSchemeProcessor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/ColorSchemeProcessor.kt) | 432 | `class ColorSchemeProcessor`, `fun clearMemoryCache`, `fun evictFromCache`, `fun removeUriFromMemoryCache`, `fun mapColorSchemePairToEntity`, `fun mapScheme` |
| [ConnectivityStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/ConnectivityStateHolder.kt) | 531 | `class BluetoothAudioDeviceState`, `class ConnectivityStateHolder`, `fun initialize`, `fun checkConnectivity`, `fun updateWifiRadioState`, `fun updateWifiInfo` |
| [DailyMixStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/DailyMixStateHolder.kt) | 156 | `class DailyMixStateHolder`, `fun initialize`, `fun removeFromDailyMix`, `fun updateDailyMix`, `fun loadPersistedDailyMix`, `fun forceUpdate` |
| [DeviceCapabilitiesViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/DeviceCapabilitiesViewModel.kt) | 642 | `class CodecInfo`, `class AudioOutputInfo`, `class AudioOutputCategory`, `class AudioCapabilities`, `class FormatSupportInfo`, `class LocalMusicStorageSummary` |
| [DuplicateSongsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/DuplicateSongsViewModel.kt) | 45 | `class DuplicateSongsUiState`, `class DuplicateSongsViewModel`, `fun scan` |
| [EqualizerViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/EqualizerViewModel.kt) | 509 | `class EqualizerUiState`, `class EqualizerViewModel`, `fun loadSystemVolume`, `fun setSystemVolume`, `fun initializeEqualizer`, `fun observeEqualizerState` |
| [ExternalMediaStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/ExternalMediaStateHolder.kt) | 361 | `class ExternalSongLoadResult`, `class ExternalMediaStateHolder`, `fun Uri`, `fun resolveDirectFilePath`, `fun persistExternalAudioForPlayback`, `fun persistExternalAlbumArt` |
| [FileExplorerStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/FileExplorerStateHolder.kt) | 560 | `class DirectoryEntry`, `class RawDirectoryEntry`, `fun mergeDirectoryEntryLists`, `class MediaStoreDirectoryIndex`, `class FileExplorerStateHolder`, `fun refreshAvailableStorages` |
| [FolderNavigationStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/FolderNavigationStateHolder.kt) | 128 | `class FolderNavigationStateHolder`, `fun setFoldersPlaylistViewState`, `fun navigateToFolder`, `fun navigateBackFolder`, `fun hydrateCurrentFolderSongsIfNeeded`, `fun findFolder` |
| [GenreDetailViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/GenreDetailViewModel.kt) | 321 | `class SortOption`, `class AlbumData`, `class SectionData`, `class ArtistSection`, `class AlbumSection`, `class FlatList` |
| [LibraryStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/LibraryStateHolder.kt) | 577 | `class GenreSeed`, `class LibraryStateHolder`, `fun effectiveFoldersStorageFilter`, `fun initialize`, `fun onCleared`, `fun startObservingLibraryData` |
| [LibraryTabsStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/LibraryTabsStateHolder.kt) | 62 | `class LibraryTabsStateHolder`, `fun showSortingSheet`, `fun hideSortingSheet`, `fun onLibraryTabSelected` |
| [LibraryViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/LibraryViewModel.kt) | 25 | `class LibraryViewModel` |
| [ListeningStatsTracker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/ListeningStatsTracker.kt) | 410 | `class ListeningStatsTracker`, `fun initialize`, `fun onVoluntarySelection`, `fun onSongChanged`, `fun onTrackChanged`, `fun onTrackChanged` |
| [LyricsSearchUiState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/LyricsSearchUiState.kt) | 14 | `interface LyricsSearchUiState`, `object Idle`, `object Loading`, `class PickResult`, `class Success`, `class NotFound` |
| [LyricsStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/LyricsStateHolder.kt) | 408 | `interface LyricsLoadCallback`, `fun onLoadingStarted`, `fun onLyricsLoaded`, `class LyricsStateHolder`, `fun initialize`, `fun loadLyricsForSong` |
| [MainViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/MainViewModel.kt) | 99 | `class MainViewModel`, `fun startSync`, `fun retrySync` |
| [MashupViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/MashupViewModel.kt) | 138 | `class DeckState`, `class MashupUiState`, `class MashupViewModel`, `fun initializeDecks`, `fun loadAllSongs`, `fun loadSong` |
| [MetadataEditStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/MetadataEditStateHolder.kt) | 214 | `class MetadataEditStateHolder`, `class MetadataEditResult`, `fun getUserFriendlyErrorMessage`, `fun resolveSongIdForMetadataEdit` |
| [MultiSelectionStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/MultiSelectionStateHolder.kt) | 132 | `class MultiSelectionStateHolder`, `fun toggleSelection`, `fun selectAll`, `fun clearSelection`, `fun isSelected`, `fun getSelectionIndex` |
| [PlaybackStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/PlaybackStateHolder.kt) | 865 | `class PlaybackStateHolder`, `fun setSliderUiMounted`, `fun clearColdStartSnapshot`, `fun rememberColdStartSnapshot`, `fun initialize`, `fun setMediaController` |
| [PlayerSheetState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/PlayerSheetState.kt) | 6 | `class PlayerSheetState` |
| [PlayerUiState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/PlayerUiState.kt) | 61 | `class PlayerUiState` |
| [PlayerViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/PlayerViewModel.kt) | 5058 | `fun List`, `fun ImmutableList`, `fun ImmutableList`, `fun ImmutableList`, `fun ImmutableList`, `fun moveQueueIndex` |
| [PlaylistDismissUndoStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/PlaylistDismissUndoStateHolder.kt) | 164 | `class PlaylistDismissUndoStateHolder`, `fun dismissPlaylistAndShowUndo`, `fun hideDismissUndoBar`, `fun observeUndoStateAgainstPlayback`, `fun undoDismissPlaylist`, `fun onCleared` |
| [PlaylistSelectionStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/PlaylistSelectionStateHolder.kt) | 128 | `class PlaylistSelectionStateHolder`, `fun toggleSelection`, `fun selectAll`, `fun clearSelection`, `fun isSelected`, `fun getSelectionIndex` |
| [PlaylistViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/PlaylistViewModel.kt) | 1150 | `class PlaylistUiState`, `class PlaylistSongsOrderMode`, `object Manual`, `class Sorted`, `class NlpPlaylistPreviewState`, `class PlaylistViewModel` |
| [QueueStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/QueueStateHolder.kt) | 56 | `class QueueStateHolder`, `fun setOriginalQueueOrder`, `fun hasOriginalQueue` |
| [QueueUndoStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/QueueUndoStateHolder.kt) | 99 | `class QueueUndoStateHolder`, `fun removeSongFromQueue`, `fun undoRemoveSongFromQueue`, `fun hideQueueItemUndoBar`, `fun onCleared` |
| [RecommendationStatsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/RecommendationStatsViewModel.kt) | 172 | `class EnrichedEngagement`, `class RecommendationStatsUiState`, `class RecommendationStatsViewModel`, `fun loadStats`, `fun simulatePlay`, `fun simulateCompletion` |
| [SearchStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/SearchStateHolder.kt) | 283 | `class SearchStateHolder`, `class SearchRequest`, `fun initialize`, `fun observeSearchRequests`, `fun updateCombinedResults`, `fun executeSearchRequest` |
| [SettingsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/SettingsViewModel.kt) | 1059 | `class SettingsUiState`, `class FailedSongInfo`, `class LyricsRefreshProgress`, `interface SettingsUiUpdate`, `class Group1`, `class Group2` |
| [SetupViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/SetupViewModel.kt) | 645 | `class SetupArtistItem`, `class SetupUiState`, `interface SetupEvent`, `class Message`, `class RestoreCompleted`, `class SetupViewModel` |
| [SleepTimerStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/SleepTimerStateHolder.kt) | 297 | `class SleepTimerStateHolder`, `fun sleepTimerPendingIntent`, `fun initialize`, `fun setSleepTimer`, `fun playCounted`, `fun cancelCountedPlay` |
| [SongInfoBottomSheetViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/SongInfoBottomSheetViewModel.kt) | 390 | `class SongInfoBottomSheetViewModel`, `class SongLocationInfo`, `class ToneTarget`, `interface ToneActionResult`, `class Success`, `class NeedsSystemWritePermission` |
| [SongRemovalStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/SongRemovalStateHolder.kt) | 68 | `class SongRemovalStateHolder` |
| [StablePlayerState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/StablePlayerState.kt) | 21 | `class StablePlayerState` |
| [StatsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/StatsViewModel.kt) | 197 | `class StatsViewModel`, `class StatsUiState`, `fun onRangeSelected`, `fun refreshWeeklyOverview`, `fun refreshHomeOverview`, `fun refreshRange` |
| [ThemeStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/ThemeStateHolder.kt) | 312 | `class ThemeStateHolder`, `fun initialize`, `fun updateLavaLampColors`, `fun requestAlbumColorSchemeGeneration`, `fun getAlbumColorSchemeFlow`, `fun ensureAlbumColorScheme` |
| [TransitionViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/TransitionViewModel.kt) | 154 | `class TransitionUiState`, `class TransitionViewModel`, `fun loadSettings`, `fun getCurrentSettings`, `fun updateDuration`, `fun updateMode` |

## `app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/exts` (1 files, 149 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DeckController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/viewmodel/exts/DeckController.kt) | 149 | `class DeckController`, `fun loadSong`, `fun buildSafePlayer`, `fun playPause`, `fun seek`, `fun setSpeed` |

## `app/src/main/java/com/quietrays/tonarc/presentation/youtube/auth` (2 files, 211 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [YouTubeLoginActivity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/youtube/auth/YouTubeLoginActivity.kt) | 156 | `class YouTubeLoginActivity`, `fun YouTubeLoginWebView` |
| [YouTubeLoginViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/youtube/auth/YouTubeLoginViewModel.kt) | 55 | `interface YouTubeLoginUiState`, `object Idle`, `object LoggingIn`, `class Success`, `class Error`, `class YouTubeLoginViewModel` |

## `app/src/main/java/com/quietrays/tonarc/presentation/youtube/dashboard` (2 files, 562 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [YouTubeDashboardScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/youtube/dashboard/YouTubeDashboardScreen.kt) | 402 | `fun YouTubeDashboardScreen`, `fun DashboardContent`, `fun ForYouSongCard`, `fun BrowseSectionItem`, `fun TrackCard`, `fun AlbumCard` |
| [YouTubeDashboardViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/presentation/youtube/dashboard/YouTubeDashboardViewModel.kt) | 160 | `interface YouTubeDashboardUiState`, `object Loading`, `class Success`, `class Error`, `class YouTubeDashboardViewModel`, `fun selectMood` |

## `app/src/main/java/com/quietrays/tonarc/ui/glancewidget` (14 files, 2,528 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BarWidget4x1.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/BarWidget4x1.kt) | 147 | `class BarWidget4x1`, `fun BarWidget4x1Content` |
| [BarWidget4x1Receiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/BarWidget4x1Receiver.kt) | 8 | `class BarWidget4x1Receiver` |
| [ControlWidget4x2.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/ControlWidget4x2.kt) | 195 | `class ControlWidget4x2`, `fun ControlWidget4x2Content` |
| [ControlWidget4x2Receiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/ControlWidget4x2Receiver.kt) | 8 | `class ControlWidget4x2Receiver` |
| [GridWidget2x2.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/GridWidget2x2.kt) | 147 | `class GridWidget2x2`, `fun GridWidget2x2Content` |
| [GridWidget2x2Receiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/GridWidget2x2Receiver.kt) | 8 | `class GridWidget2x2Receiver` |
| [PlayerControlActionCallback.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/PlayerControlActionCallback.kt) | 83 | `class PlayerControlActionCallback`, `object PlayerActions` |
| [PlayerInfoStateDefinition.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/PlayerInfoStateDefinition.kt) | 61 | `object PlayerInfoStateDefinition`, `class PlayerInfoJsonSerializer` |
| [TonarcGlanceWidget.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/TonarcGlanceWidget.kt) | 1366 | `class TonarcGlanceWidget`, `fun WidgetUi`, `fun VeryThinWidgetLayout`, `fun ThinWidgetLayout`, `fun GabeTwoHeightWidgetLayout`, `fun GabeWidgetLayout` |
| [TonarcGlanceWidgetReceiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/TonarcGlanceWidgetReceiver.kt) | 8 | `class TonarcGlanceWidgetReceiver` |
| [WidgetArtworkDecoder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/WidgetArtworkDecoder.kt) | 80 | `fun decodeWidgetAlbumArtBitmap`, `fun readBytesCapped` |
| [WidgetComponents.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/WidgetComponents.kt) | 276 | `fun AlbumArtImage`, `fun decodeAlbumArtFromUri`, `fun WidgetIconButton`, `fun PreviousButton`, `fun NextButton`, `fun PlayPauseButton` |
| [WidgetUpdateReceiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/WidgetUpdateReceiver.kt) | 52 | `class WidgetUpdateReceiver` |
| [WidgetUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/glancewidget/WidgetUtils.kt) | 89 | `object AlbumArtBitmapCache`, `fun getBitmap`, `fun putBitmap`, `fun getKey`, `class WidgetColors`, `fun PlayerInfo` |

## `app/src/main/java/com/quietrays/tonarc/ui/theme` (7 files, 1,478 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [Color.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/theme/Color.kt) | 22 | - |
| [ColorRoles.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/theme/ColorRoles.kt) | 730 | `class ColorScoringConfig`, `class ColorExtractionConfig`, `class ScoredHct`, `class RepresentativeArtworkColor`, `fun clearExtractedColorCache`, `fun extractSeedColor` |
| [GenreColors.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/theme/GenreColors.kt) | 242 | `class GenreThemeColor`, `object GenreThemeUtils`, `fun isUnknownGenreId`, `fun getGenreThemeColor`, `fun getGenreThemeColor`, `fun androidx` |
| [Shape.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/theme/Shape.kt) | 11 | - |
| [ShapeCache.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/theme/ShapeCache.kt) | 90 | `object ShapeCache`, `class RoundedPolygonShape` |
| [Theme.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/theme/Theme.kt) | 147 | `fun TonarcStatusBarStyle`, `fun TonarcTheme` |
| [Type.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/ui/theme/Type.kt) | 236 | - |

## `app/src/main/java/com/quietrays/tonarc/utils` (30 files, 5,650 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtCacheManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/AlbumArtCacheManager.kt) | 291 | `object AlbumArtCacheManager`, `class CacheEvictionCandidate`, `fun getCachedFileCount`, `fun getAlbumArtFiles`, `fun snapshotFilesForCleanup`, `fun getAllAlbumArtRelatedFiles` |
| [AlbumArtUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/AlbumArtUtils.kt) | 581 | `object AlbumArtUtils`, `fun getAlbumArtUri`, `fun getAlbumArtUriForLibraryScan`, `fun getCachedAlbumArtUri`, `fun hasCachedAlbumArt`, `fun getEmbeddedAlbumArtUri` |
| [AppLocaleManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/AppLocaleManager.kt) | 57 | `object AppLocaleManager`, `fun currentLanguageTag`, `fun applyLanguage`, `fun wrapContext` |
| [AppShortcutManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/AppShortcutManager.kt) | 76 | `class AppShortcutManager`, `fun updateLastPlaylistShortcut`, `fun removeLastPlaylistShortcut` |
| [ArtworkTransportSanitizer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/ArtworkTransportSanitizer.kt) | 130 | `object ArtworkTransportSanitizer`, `class Config`, `fun sanitizeEncodedBytes`, `fun decodeBoundedBitmap`, `fun scaleBitmapIfNeeded`, `fun encodeBitmap` |
| [AudioMetaUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/AudioMetaUtils.kt) | 174 | `class AudioMeta`, `object AudioMetaUtils`, `fun mimeTypeToFormat` |
| [ColorUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/ColorUtils.kt) | 125 | `fun getContrastColor`, `fun createScalableBackgroundBitmap` |
| [CrashHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/CrashHandler.kt) | 131 | `class CrashLogData`, `fun getFullLog`, `object CrashHandler`, `fun install`, `fun saveCrashLog`, `fun getStackTraceString` |
| [DirectoryFilterUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/DirectoryFilterUtils.kt) | 25 | `object DirectoryFilterUtils` |
| [DirectoryRuleResolver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/DirectoryRuleResolver.kt) | 55 | `class DirectoryRuleResolver`, `fun isBlocked`, `fun normalize`, `fun isParentOrSame` |
| [Envelope.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/Envelope.kt) | 27 | `fun envelope` |
| [Extensions.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/Extensions.kt) | 177 | `fun Color`, `fun String`, `fun String`, `fun String`, `fun String` |
| [FileDeletionUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/FileDeletionUtils.kt) | 163 | `object FileDeletionUtils`, `fun getDeleteRequestIntentSender`, `class FileInfo` |
| [Formats.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/Formats.kt) | 88 | `fun formatDuration`, `fun formatTotalDuration`, `fun formatListeningDurationLong`, `fun formatListeningDurationCompact`, `fun formatSongCount`, `fun formatTimeAgo` |
| [FuzzySearchMatcher.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/FuzzySearchMatcher.kt) | 124 | `object FuzzySearchMatcher`, `fun damerauLevenshteinDistance`, `fun similarity`, `fun scoreMatch`, `fun isMatch` |
| [LocalArtworkUri.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/LocalArtworkUri.kt) | 119 | `object LocalArtworkUri`, `fun buildSongUri`, `fun buildSongUriWithTimestamp`, `fun isLocalArtworkUri`, `fun isLocalArtworkUri`, `fun parseSongId` |
| [LogUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/LogUtils.kt) | 33 | `object LogUtils`, `fun getTag`, `fun buildLogMessage`, `fun d`, `fun i`, `fun w` |
| [LyricsImportSecurity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/LyricsImportSecurity.kt) | 291 | `class ValidatedLyricsImport`, `class LyricsImportFailureReason`, `interface LyricsImportValidationResult`, `class Valid`, `class Invalid`, `object LyricsImportSecurity` |
| [LyricsUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/LyricsUtils.kt) | 1320 | `object MultiLangRomanizer`, `fun isJapanese`, `fun isKorean`, `fun isHindi`, `fun isPunjabi`, `fun isCyrillic` |
| [MediaItemBuilder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/MediaItemBuilder.kt) | 368 | `object MediaItemBuilder`, `fun build`, `fun buildForExternalController`, `fun playbackUri`, `fun playbackMimeType`, `fun playbackUri` |
| [MediaMetadataRetrieverPool.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/MediaMetadataRetrieverPool.kt) | 82 | `object MediaMetadataRetrieverPool`, `fun acquire`, `fun release`, `fun clear`, `fun poolSize`, `fun totalCreated` |
| [MediaStorePermissionHelper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/MediaStorePermissionHelper.kt) | 321 | `object MediaStorePermissionHelper`, `class DeleteRequest`, `fun getMediaStoreUri`, `fun getMediaStoreUri`, `fun getAudioMediaStoreUris`, `fun isMediaStoreItemUriString` |
| [MediaStoreSelectionUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/MediaStoreSelectionUtils.kt) | 44 | `fun buildLocalAudioSelection` |
| [NetworkRetryUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/NetworkRetryUtils.kt) | 43 | `object NetworkRetryUtils`, `fun Throwable` |
| [PlaylistCoverColors.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/PlaylistCoverColors.kt) | 28 | `fun resolvePlaylistCoverContentColor` |
| [QueueUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/QueueUtils.kt) | 191 | `object QueueUtils`, `fun generateShuffleOrder`, `fun buildAnchoredShuffleQueue` |
| [StorageUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/StorageUtils.kt) | 136 | `class StorageType`, `class StorageInfo`, `object StorageUtils`, `fun getAvailableStorages`, `fun getVolumePath`, `fun determineStorageType` |
| [TraceUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/TraceUtils.kt) | 38 | - |
| [TtmlLyricsParser.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/TtmlLyricsParser.kt) | 205 | `object TtmlLyricsParser`, `fun parseToEnhancedLrc`, `fun normalizeTtmlDocument`, `fun resolveParagraphStartMs`, `fun serializeChildren`, `fun serializeNode` |
| [ZipShareHelper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/ZipShareHelper.kt) | 207 | `object ZipShareHelper`, `fun isLargeZip`, `fun formatFileSize`, `fun cleanupTempZips`, `fun cleanupOldZips`, `fun shareZipFile` |

## `app/src/main/java/com/quietrays/tonarc/utils/shapes` (1 files, 72 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [RoundedStarShape.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/quietrays/tonarc/utils/shapes/RoundedStarShape.kt) | 72 | `class RoundedStarShape`, `fun pointAt`, `fun mapRange` |

## `app/src/main/res/drawable` (132 files, 1,303 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [accordion.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/accordion.xml) | 9 | - |
| [acoustic_guitar.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/acoustic_guitar.xml) | 9 | - |
| [alt_video.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/alt_video.xml) | 9 | - |
| [banjo.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/banjo.xml) | 9 | - |
| [baseline_deselect_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/baseline_deselect_24.xml) | 5 | - |
| [bongos.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/bongos.xml) | 9 | - |
| [clasic_piano.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/clasic_piano.xml) | 10 | - |
| [conga.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/conga.xml) | 9 | - |
| [drag_order_icon.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/drag_order_icon.xml) | 30 | - |
| [drum.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/drum.xml) | 13 | - |
| [electronic_sound.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/electronic_sound.xml) | 9 | - |
| [fdroid.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/fdroid.xml) | 9 | - |
| [github.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/github.xml) | 5 | - |
| [harmonica.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/harmonica.xml) | 9 | - |
| [home_24_rounded_filled.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/home_24_rounded_filled.xml) | 9 | - |
| [ic_folder.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_folder.xml) | 9 | - |
| [ic_jellyfin.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_jellyfin.xml) | 9 | - |
| [ic_music_placeholder.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_music_placeholder.xml) | 10 | - |
| [ic_music_placeholder_preview.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_music_placeholder_preview.xml) | 10 | - |
| [ic_navidrome.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_navidrome.xml) | 33 | - |
| [ic_navidrome_md3.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_navidrome_md3.xml) | 15 | - |
| [ic_phonef.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_phonef.xml) | 9 | - |
| [ic_play_arrow_widget_preview.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_play_arrow_widget_preview.xml) | 3 | - |
| [ic_shortcut_playlist.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_shortcut_playlist.xml) | 10 | - |
| [ic_shortcut_shuffle.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_shortcut_shuffle.xml) | 10 | - |
| [ic_skip_next_widget_preview.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_skip_next_widget_preview.xml) | 3 | - |
| [ic_skip_previous_widget_preview.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_skip_previous_widget_preview.xml) | 3 | - |
| [ic_subsonic.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/ic_subsonic.xml) | 18 | - |
| [idk_indie_ig.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/idk_indie_ig.xml) | 27 | - |
| [maracas.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/maracas.xml) | 18 | - |
| [metal_guitar.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/metal_guitar.xml) | 9 | - |
| [metal_guitar_2.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/metal_guitar_2.xml) | 9 | - |
| [monochrome_player.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/monochrome_player.xml) | 26 | - |
| [new_monochrome.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/new_monochrome.xml) | 22 | - |
| [outline_graph_1_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/outline_graph_1_24.xml) | 5 | - |
| [outline_high_quality_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/outline_high_quality_24.xml) | 5 | - |
| [outline_restart_alt_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/outline_restart_alt_24.xml) | 5 | - |
| [outline_save_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/outline_save_24.xml) | 10 | - |
| [pixelplayer_base_monochrome.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/pixelplayer_base_monochrome.xml) | 22 | - |
| [pop_mic.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/pop_mic.xml) | 18 | - |
| [punk.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/punk.xml) | 9 | - |
| [rapper.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rapper.xml) | 12 | - |
| [rattle.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rattle.xml) | 9 | - |
| [rock.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rock.xml) | 9 | - |
| [round_developer_board_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/round_developer_board_24.xml) | 5 | - |
| [round_favorite_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/round_favorite_24.xml) | 5 | - |
| [round_favorite_border_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/round_favorite_border_24.xml) | 5 | - |
| [round_library_music_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/round_library_music_24.xml) | 5 | - |
| [round_newspaper_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/round_newspaper_24.xml) | 5 | - |
| [round_select_all_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/round_select_all_24.xml) | 5 | - |
| [rounded_alarm_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_alarm_24.xml) | 5 | - |
| [rounded_album_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_album_24.xml) | 5 | - |
| [rounded_align_justify_space_even_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_align_justify_space_even_24.xml) | 5 | - |
| [rounded_arrow_back_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_arrow_back_24.xml) | 5 | - |
| [rounded_arrow_forward_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_arrow_forward_24.xml) | 5 | - |
| [rounded_artist_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_artist_24.xml) | 5 | - |
| [rounded_attach_file_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_attach_file_24.xml) | 5 | - |
| [rounded_audio_file_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_audio_file_24.xml) | 5 | - |
| [rounded_broken_image_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_broken_image_24.xml) | 5 | - |
| [rounded_celebration_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_celebration_24.xml) | 5 | - |
| [rounded_check_circle_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_check_circle_24.xml) | 5 | - |
| [rounded_chevron_right_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_chevron_right_24.xml) | 5 | - |
| [rounded_circle_notifications_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_circle_notifications_24.xml) | 5 | - |
| [rounded_close_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_close_24.xml) | 5 | - |
| [rounded_create_new_folder_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_create_new_folder_24.xml) | 5 | - |
| [rounded_delete_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_delete_24.xml) | 5 | - |
| [rounded_edit_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_edit_24.xml) | 5 | - |
| [rounded_explosion_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_explosion_24.xml) | 5 | - |
| [rounded_favorite_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_favorite_24.xml) | 5 | - |
| [rounded_folder_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_folder_24.xml) | 5 | - |
| [rounded_folder_open_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_folder_open_24.xml) | 5 | - |
| [rounded_headphones_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_headphones_24.xml) | 5 | - |
| [rounded_home_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_home_24.xml) | 5 | - |
| [rounded_hourglass_empty_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_hourglass_empty_24.xml) | 5 | - |
| [rounded_instant_mix_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_instant_mix_24.xml) | 5 | - |
| [rounded_keyboard_arrow_down_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_keyboard_arrow_down_24.xml) | 5 | - |
| [rounded_library_music_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_library_music_24.xml) | 5 | - |
| [rounded_lyrics_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_lyrics_24.xml) | 5 | - |
| [rounded_manage_search_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_manage_search_24.xml) | 5 | - |
| [rounded_monitoring_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_monitoring_24.xml) | 5 | - |
| [rounded_music_note_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_music_note_24.xml) | 5 | - |
| [rounded_music_off_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_music_off_24.xml) | 5 | - |
| [rounded_notifications_active_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_notifications_active_24.xml) | 5 | - |
| [rounded_pause_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_pause_24.xml) | 5 | - |
| [rounded_pause_filled_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_pause_filled_24.xml) | 9 | - |
| [rounded_person_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_person_24.xml) | 5 | - |
| [rounded_play_arrow_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_play_arrow_24.xml) | 5 | - |
| [rounded_play_arrow_filled_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_play_arrow_filled_24.xml) | 9 | - |
| [rounded_playlist_add_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_playlist_add_24.xml) | 5 | - |
| [rounded_playlist_play_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_playlist_play_24.xml) | 5 | - |
| [rounded_question_mark_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_question_mark_24.xml) | 5 | - |
| [rounded_queue_music_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_queue_music_24.xml) | 5 | - |
| [rounded_repeat_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_repeat_24.xml) | 5 | - |
| [rounded_repeat_one_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_repeat_one_24.xml) | 5 | - |
| [rounded_rounded_corner_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_rounded_corner_24.xml) | 5 | - |
| [rounded_schedule_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_schedule_24.xml) | 5 | - |
| [rounded_search_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_search_24.xml) | 5 | - |
| [rounded_settings_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_settings_24.xml) | 5 | - |
| [rounded_shuffle_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_shuffle_24.xml) | 5 | - |
| [rounded_skip_next_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_skip_next_24.xml) | 5 | - |
| [rounded_skip_next_filled_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_skip_next_filled_24.xml) | 9 | - |
| [rounded_skip_previous_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_skip_previous_24.xml) | 5 | - |
| [rounded_skip_previous_filled_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_skip_previous_filled_24.xml) | 9 | - |
| [rounded_speaker_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_speaker_24.xml) | 5 | - |
| [rounded_surround_sound_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_surround_sound_24.xml) | 5 | - |
| [rounded_timer_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_timer_24.xml) | 5 | - |
| [rounded_touch_app_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_touch_app_24.xml) | 5 | - |
| [rounded_tv_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_tv_24.xml) | 10 | - |
| [rounded_upload_file_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_upload_file_24.xml) | 5 | - |
| [rounded_view_carousel_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_view_carousel_24.xml) | 5 | - |
| [rounded_view_column_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_view_column_24.xml) | 5 | - |
| [rounded_view_week_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_view_week_24.xml) | 5 | - |
| [rounded_volume_down_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/rounded_volume_down_24.xml) | 5 | - |
| [sax.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/sax.xml) | 12 | - |
| [shortcut_playlist_purple.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/shortcut_playlist_purple.xml) | 10 | - |
| [star_angle.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/star_angle.xml) | 11 | - |
| [synth_piano.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/synth_piano.xml) | 9 | - |
| [tab_24.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/tab_24.xml) | 11 | - |
| [telegram.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/telegram.xml) | 3 | - |
| [welcome_art.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/welcome_art.xml) | 61 | - |
| [widget_album_art_placeholder.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_album_art_placeholder.xml) | 6 | - |
| [widget_button_primary_background.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_button_primary_background.xml) | 6 | - |
| [widget_button_secondary_background.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_button_secondary_background.xml) | 6 | - |
| [widget_preview_album_art_background.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_preview_album_art_background.xml) | 6 | - |
| [widget_preview_background.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_preview_background.xml) | 6 | - |
| [widget_preview_bar_4x1_image.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_preview_bar_4x1_image.xml) | 63 | - |
| [widget_preview_circular_button.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_preview_circular_button.xml) | 6 | - |
| [widget_preview_control_4x2_image.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_preview_control_4x2_image.xml) | 81 | - |
| [widget_preview_full.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_preview_full.xml) | 64 | - |
| [widget_preview_grid_2x2_image.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_preview_grid_2x2_image.xml) | 54 | - |
| [widget_preview_play_button_background.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_preview_play_button_background.xml) | 6 | - |
| [widget_surface_background.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable/widget_surface_background.xml) | 6 | - |

## `app/src/main/res/drawable-v31` (1 files, 64 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [widget_preview_full.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/drawable-v31/widget_preview_full.xml) | 64 | - |

## `app/src/main/res/font` (2 files, 57,082 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [genre_variable.ttf](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/font/genre_variable.ttf) | 17743 | - |
| [gflex_variable.ttf](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/font/gflex_variable.ttf) | 39339 | - |

## `app/src/main/res/layout` (4 files, 286 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [glance_default_layout.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/layout/glance_default_layout.xml) | 10 | - |
| [widget_preview_bar_4x1.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/layout/widget_preview_bar_4x1.xml) | 85 | - |
| [widget_preview_control_4x2.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/layout/widget_preview_control_4x2.xml) | 119 | - |
| [widget_preview_grid_2x2.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/layout/widget_preview_grid_2x2.xml) | 72 | - |

## `app/src/main/res/mipmap-anydpi-v26` (2 files, 12 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml) | 6 | - |
| [ic_launcher_round.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml) | 6 | - |

## `app/src/main/res/mipmap-hdpi` (4 files, 59 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-hdpi/ic_launcher.webp) | 21 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-hdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-hdpi/ic_launcher_foreground.webp) | 16 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-hdpi/ic_launcher_round.webp) | 21 | - |

## `app/src/main/res/mipmap-mdpi` (4 files, 42 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-mdpi/ic_launcher.webp) | 16 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-mdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-mdpi/ic_launcher_foreground.webp) | 9 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-mdpi/ic_launcher_round.webp) | 16 | - |

## `app/src/main/res/mipmap-xhdpi` (4 files, 57 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xhdpi/ic_launcher.webp) | 16 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xhdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xhdpi/ic_launcher_foreground.webp) | 24 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xhdpi/ic_launcher_round.webp) | 16 | - |

## `app/src/main/res/mipmap-xxhdpi` (4 files, 128 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxhdpi/ic_launcher.webp) | 35 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxhdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxhdpi/ic_launcher_foreground.webp) | 57 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxhdpi/ic_launcher_round.webp) | 35 | - |

## `app/src/main/res/mipmap-xxxhdpi` (4 files, 173 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp) | 52 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxxhdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxxhdpi/ic_launcher_foreground.webp) | 68 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.webp) | 52 | - |

## `app/src/main/res/values` (15 files, 2,084 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [colors.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/colors.xml) | 8 | - |
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings.xml) | 285 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_auth.xml) | 47 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_components.xml) | 177 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_presentation_batch_b.xml) | 69 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_presentation_batch_c.xml) | 68 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_presentation_batch_d.xml) | 105 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_presentation_batch_e.xml) | 68 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_presentation_batch_f.xml) | 143 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_presentation_batch_g.xml) | 516 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_screens.xml) | 254 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings_settings.xml) | 279 | - |
| [themes.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/themes.xml) | 21 | - |

## `app/src/main/res/values-ar` (13 files, 1,797 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/plurals.xml) | 75 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings.xml) | 216 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_presentation_batch_b.xml) | 66 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_presentation_batch_e.xml) | 75 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_presentation_batch_g.xml) | 377 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ar/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-de` (13 files, 1,745 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings.xml) | 216 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_presentation_batch_b.xml) | 62 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_presentation_batch_e.xml) | 63 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_presentation_batch_g.xml) | 377 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-de/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-es` (13 files, 1,745 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings.xml) | 216 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_presentation_batch_b.xml) | 62 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_presentation_batch_e.xml) | 63 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_presentation_batch_g.xml) | 377 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-es/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-fr` (13 files, 1,745 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings.xml) | 216 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_presentation_batch_b.xml) | 62 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_presentation_batch_e.xml) | 63 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_presentation_batch_g.xml) | 377 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-fr/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-in` (13 files, 1,745 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings.xml) | 216 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_presentation_batch_b.xml) | 62 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_presentation_batch_e.xml) | 63 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_presentation_batch_g.xml) | 377 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-in/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-it` (13 files, 1,745 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings.xml) | 216 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_presentation_batch_b.xml) | 62 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_presentation_batch_e.xml) | 63 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_presentation_batch_g.xml) | 377 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-it/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-ko` (13 files, 1,731 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/plurals.xml) | 30 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings.xml) | 216 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_presentation_batch_b.xml) | 61 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_presentation_batch_e.xml) | 60 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_presentation_batch_g.xml) | 376 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ko/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-nb` (13 files, 1,745 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings.xml) | 216 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_presentation_batch_b.xml) | 62 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_presentation_batch_e.xml) | 63 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_presentation_batch_g.xml) | 377 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-nb/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-night` (1 files, 10 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [themes.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-night/themes.xml) | 10 | - |

## `app/src/main/res/values-ru` (13 files, 1,749 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings.xml) | 216 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_presentation_batch_b.xml) | 64 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_presentation_batch_e.xml) | 65 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_presentation_batch_g.xml) | 377 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-ru/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-tr` (13 files, 1,769 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings.xml) | 240 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_auth.xml) | 41 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_components.xml) | 165 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_presentation_batch_b.xml) | 62 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_presentation_batch_c.xml) | 61 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_presentation_batch_d.xml) | 99 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_presentation_batch_e.xml) | 63 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_presentation_batch_f.xml) | 138 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_presentation_batch_g.xml) | 377 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_screens.xml) | 229 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-tr/strings_settings.xml) | 250 | - |

## `app/src/main/res/values-zh-rCN` (13 files, 1,984 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/plurals.xml) | 30 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings.xml) | 241 | - |
| [strings_auth.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_auth.xml) | 47 | - |
| [strings_components.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_components.xml) | 177 | - |
| [strings_presentation_batch_b.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_presentation_batch_b.xml) | 68 | - |
| [strings_presentation_batch_c.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_presentation_batch_c.xml) | 67 | - |
| [strings_presentation_batch_d.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_presentation_batch_d.xml) | 105 | - |
| [strings_presentation_batch_e.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_presentation_batch_e.xml) | 65 | - |
| [strings_presentation_batch_f.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_presentation_batch_f.xml) | 143 | - |
| [strings_presentation_batch_g.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_presentation_batch_g.xml) | 516 | - |
| [strings_presentation_batch_h.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_presentation_batch_h.xml) | 5 | - |
| [strings_screens.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_screens.xml) | 253 | - |
| [strings_settings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values-zh-rCN/strings_settings.xml) | 267 | - |

## `app/src/main/res/xml` (10 files, 160 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [backup_rules.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/backup_rules.xml) | 16 | - |
| [bar_widget_4x1_info.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/bar_widget_4x1_info.xml) | 15 | - |
| [control_widget_4x2_info.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/control_widget_4x2_info.xml) | 15 | - |
| [data_extraction_rules.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/data_extraction_rules.xml) | 32 | - |
| [file_paths.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/file_paths.xml) | 9 | - |
| [grid_widget_2x2_info.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/grid_widget_2x2_info.xml) | 16 | - |
| [locales_config.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/locales_config.xml) | 15 | - |
| [network_security_config.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/network_security_config.xml) | 13 | - |
| [shortcuts.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/shortcuts.xml) | 15 | - |
| [tonarc_glance_widget_info.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/tonarc_glance_widget_info.xml) | 14 | - |

## `app/src/release/generated/baselineProfiles` (2 files, 80,806 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [baseline-prof.txt](file:///home/dharshan/PixelPlayerOSS/app/src/release/generated/baselineProfiles/baseline-prof.txt) | 43587 | - |
| [startup-prof.txt](file:///home/dharshan/PixelPlayerOSS/app/src/release/generated/baselineProfiles/startup-prof.txt) | 37219 | - |

## `app/src/test/java/com/quietrays/tonarc` (2 files, 41 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExampleUnitTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/ExampleUnitTest.kt) | 17 | `class ExampleUnitTest`, `fun addition_isCorrect` |
| [MainCoroutineExtension.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/MainCoroutineExtension.kt) | 24 | `class MainCoroutineExtension` |

## `app/src/test/java/com/quietrays/tonarc/data/backup` (1 files, 175 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupManagerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/BackupManagerTest.kt) | 175 | `class BackupManagerTest`, `fun setUp`, `fun restorePlan` |

## `app/src/test/java/com/quietrays/tonarc/data/backup/format` (2 files, 180 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupFormatDetectorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/format/BackupFormatDetectorTest.kt) | 56 | `class BackupFormatDetectorTest` |
| [LegacyPayloadAdapterTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/format/LegacyPayloadAdapterTest.kt) | 124 | `class LegacyPayloadAdapterTest` |

## `app/src/test/java/com/quietrays/tonarc/data/backup/model` (1 files, 85 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupSectionTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/model/BackupSectionTest.kt) | 85 | `class BackupSectionTest` |

## `app/src/test/java/com/quietrays/tonarc/data/backup/module` (2 files, 163 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [EngagementStatsModuleHandlerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/module/EngagementStatsModuleHandlerTest.kt) | 99 | `class EngagementStatsModuleHandlerTest` |
| [FavoritesModuleHandlerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/module/FavoritesModuleHandlerTest.kt) | 64 | `class FavoritesModuleHandlerTest` |

## `app/src/test/java/com/quietrays/tonarc/data/backup/restore` (1 files, 140 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [RestoreExecutorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/restore/RestoreExecutorTest.kt) | 140 | `class RestoreExecutorTest`, `fun restorePlan` |

## `app/src/test/java/com/quietrays/tonarc/data/backup/validation` (3 files, 359 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ContentSanitizerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/validation/ContentSanitizerTest.kt) | 81 | `class ContentSanitizerTest` |
| [ManifestValidatorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/validation/ManifestValidatorTest.kt) | 131 | `class ManifestValidatorTest`, `fun sha256` |
| [ModuleSchemaValidatorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/backup/validation/ModuleSchemaValidatorTest.kt) | 147 | `class ModuleSchemaValidatorTest` |

## `app/src/test/java/com/quietrays/tonarc/data/database` (2 files, 71 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeSongEntityTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/database/NavidromeSongEntityTest.kt) | 38 | `class NavidromeSongEntityTest` |
| [YouTubeSongEntityTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/database/YouTubeSongEntityTest.kt) | 33 | `class YouTubeSongEntityTest` |

## `app/src/test/java/com/quietrays/tonarc/data/equalizer` (1 files, 79 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExternalAudioEffectSessionTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/equalizer/ExternalAudioEffectSessionTest.kt) | 79 | `class ExternalAudioEffectSessionTest`, `fun setUp` |

## `app/src/test/java/com/quietrays/tonarc/data/jellyfin` (1 files, 99 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/jellyfin/JellyfinRepositoryTest.kt) | 99 | `class JellyfinRepositoryTest` |

## `app/src/test/java/com/quietrays/tonarc/data/jellyfin/model` (1 files, 101 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinCredentialsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/jellyfin/model/JellyfinCredentialsTest.kt) | 101 | `class JellyfinCredentialsTest`, `fun creds` |

## `app/src/test/java/com/quietrays/tonarc/data/library` (1 files, 70 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DuplicateFinderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/library/DuplicateFinderTest.kt) | 70 | `class DuplicateFinderTest`, `fun song` |

## `app/src/test/java/com/quietrays/tonarc/data/listenbrainz` (4 files, 256 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ListenBrainzEndpointTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/listenbrainz/ListenBrainzEndpointTest.kt) | 69 | `class ListenBrainzEndpointTest`, `fun parseBaseUrl_defaultsSchemeToHttpsAndAppendsSlash`, `fun parseBaseUrl_keepsPathPrefixAndExplicitScheme`, `fun parseBaseUrl_rejectsNonHttpSchemesAndGarbage`, `fun rewrite_withoutCustomBaseLeavesRequestUntouched`, `fun rewrite_rerootsApiPathUnderCustomBaseWithPathPrefix` |
| [ListenBrainzLabsRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/listenbrainz/ListenBrainzLabsRepositoryTest.kt) | 84 | `class ListenBrainzLabsRepositoryTest` |
| [ListenBrainzProfileStatsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/listenbrainz/ListenBrainzProfileStatsTest.kt) | 63 | `class ListenBrainzProfileStatsTest`, `fun nullWhenServerExposesNeitherEndpoint`, `fun carriesListenCountWithoutPlayingNowSupport`, `fun supportedButIdlePlayingNowKeepsNullTrack`, `fun mapsNowPlayingTrackAndArtist` |
| [ScrobbleManagerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/listenbrainz/ScrobbleManagerTest.kt) | 40 | `class ScrobbleManagerTest` |

## `app/src/test/java/com/quietrays/tonarc/data/model` (2 files, 102 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SmartPlaylistRuleTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/model/SmartPlaylistRuleTest.kt) | 47 | `class SmartPlaylistRuleTest` |
| [SortOptionTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/model/SortOptionTest.kt) | 55 | `class SortOptionTest` |

## `app/src/test/java/com/quietrays/tonarc/data/musicbrainz` (1 files, 84 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MusicBrainzApiServiceTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/musicbrainz/MusicBrainzApiServiceTest.kt) | 84 | `class MusicBrainzApiServiceTest` |

## `app/src/test/java/com/quietrays/tonarc/data/navidrome` (1 files, 104 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/navidrome/NavidromeRepositoryTest.kt) | 104 | `class NavidromeRepositoryTest` |

## `app/src/test/java/com/quietrays/tonarc/data/navidrome/model` (1 files, 79 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeCredentialsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/navidrome/model/NavidromeCredentialsTest.kt) | 79 | `class NavidromeCredentialsTest` |

## `app/src/test/java/com/quietrays/tonarc/data/network/navidrome` (1 files, 80 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeApiServiceAuthTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/network/navidrome/NavidromeApiServiceAuthTest.kt) | 80 | `class NavidromeApiServiceAuthTest` |

## `app/src/test/java/com/quietrays/tonarc/data/network/youtube` (3 files, 343 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [InnertubeLiveNetworkTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/network/youtube/InnertubeLiveNetworkTest.kt) | 65 | `class InnertubeLiveNetworkTest`, `fun testLiveSearchAndStream` |
| [InnertubeParserTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/network/youtube/InnertubeParserTest.kt) | 228 | `class InnertubeParserTest`, `fun parsePlayerResponse_extractsAdaptiveAudioStreams`, `fun parseTranscriptLyrics_generatesFormattedLrcTimestamps`, `fun parseSearchResults_extractsContinuationToken`, `fun parseRadioTracks_extractsPlaylistPanelItems` |
| [InnertubeRawDumpTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/network/youtube/InnertubeRawDumpTest.kt) | 50 | `class InnertubeRawDumpTest`, `fun dumpRawResponses` |

## `app/src/test/java/com/quietrays/tonarc/data/offline` (1 files, 51 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudOfflineRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/offline/CloudOfflineRepositoryTest.kt) | 51 | `class CloudOfflineRepositoryTest`, `fun song` |

## `app/src/test/java/com/quietrays/tonarc/data/playlist` (1 files, 136 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SmartPlaylistBuilderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/playlist/SmartPlaylistBuilderTest.kt) | 136 | `class SmartPlaylistBuilderTest`, `fun daysAgo`, `fun song`, `fun stats` |

## `app/src/test/java/com/quietrays/tonarc/data/playlist/nlp` (8 files, 796 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [GenreTaxonomyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/playlist/nlp/GenreTaxonomyTest.kt) | 68 | `class GenreTaxonomyTest`, `fun fam`, `fun qfam` |
| [LocalMetadataHeuristicsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/playlist/nlp/LocalMetadataHeuristicsTest.kt) | 56 | `class LocalMetadataHeuristicsTest` |
| [MultiMoodTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/playlist/nlp/MultiMoodTest.kt) | 98 | `class MultiMoodTest`, `fun song` |
| [NegationTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/playlist/nlp/NegationTest.kt) | 63 | `class NegationTest`, `fun song` |
| [NlpTextTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/playlist/nlp/NlpTextTest.kt) | 47 | `class NlpTextTest` |
| [PlaylistIntentEngineTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/playlist/nlp/PlaylistIntentEngineTest.kt) | 288 | `class PlaylistIntentEngineTest`, `fun song`, `fun generate` |
| [SimilarityIntentTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/playlist/nlp/SimilarityIntentTest.kt) | 80 | `class SimilarityIntentTest`, `fun song`, `fun generate` |
| [VibeVectorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/playlist/nlp/VibeVectorTest.kt) | 96 | `class VibeVectorTest`, `fun song` |

## `app/src/test/java/com/quietrays/tonarc/data/preferences` (1 files, 156 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [UserPreferencesRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/preferences/UserPreferencesRepositoryTest.kt) | 156 | `class UserPreferencesRepositoryTest` |

## `app/src/test/java/com/quietrays/tonarc/data/provider` (1 files, 93 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SharedArtworkContentProviderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/provider/SharedArtworkContentProviderTest.kt) | 93 | `class SharedArtworkContentProviderTest`, `fun buildSongUri_usesDedicatedArtworkAuthority`, `fun buildSongUri_preservesCacheBustToken`, `fun parseSongId_rejectsOtherAuthorities`, `fun parseSongId_readsSharedArtworkSongUri`, `fun cloudArtworkUri_roundTripsNavidromeArtwork` |

## `app/src/test/java/com/quietrays/tonarc/data/recommendation` (4 files, 350 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AdaptiveWeightTunerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/recommendation/AdaptiveWeightTunerTest.kt) | 38 | `class AdaptiveWeightTunerTest` |
| [CandidateAggregatorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/recommendation/CandidateAggregatorTest.kt) | 88 | `class CandidateAggregatorTest`, `fun testSong` |
| [ItemEmbeddingStoreTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/recommendation/ItemEmbeddingStoreTest.kt) | 38 | `class ItemEmbeddingStoreTest` |
| [PersonalizedRankerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/recommendation/PersonalizedRankerTest.kt) | 186 | `class PersonalizedRankerTest`, `fun testSong` |

## `app/src/test/java/com/quietrays/tonarc/data/repository` (5 files, 1,105 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ArtistImageRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/repository/ArtistImageRepositoryTest.kt) | 106 | `class ArtistImageRepositoryTest`, `fun userPreferencesRepository` |
| [FolderTreeBuilderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/repository/FolderTreeBuilderTest.kt) | 96 | `class FolderTreeBuilderTest`, `fun inferRemovableStorageRoots_usesSdCardVolumeRoot`, `fun buildFolderTreeForRoots_includesSdCardFolders`, `fun buildFolderTreeForRoots_doesNotMatchSiblingPathPrefix`, `fun inferRemovableStorageRoots_supportsMediaRwSdCardPaths`, `fun folderSong` |
| [LyricsRepositoryImplTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/repository/LyricsRepositoryImplTest.kt) | 438 | `class LyricsRepositoryImplTest`, `fun getLyrics_returnsSongLyricsBeforeNeedingStorageRead`, `fun getLyrics_apiFirst_usesStoredLyricsBeforeCallingLrcLib`, `fun fetchFromRemote_returnsStoredLyricsWithoutCallingApi`, `fun fetchFromRemote_whenExternalLyricsDisabled_doesNotCallLrcLib`, `fun fetchFromRemote_rejectsDurationOnlySearchMatch` |
| [MusicRepositoryImplTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/repository/MusicRepositoryImplTest.kt) | 334 | `class MusicRepositoryImplTest`, `fun setUp`, `fun tearDown`, `fun createSongEntity` |
| [SmartPlaylistGeneratorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/repository/SmartPlaylistGeneratorTest.kt) | 131 | `class SmartPlaylistGeneratorTest`, `fun setUp`, `fun createSongEntity` |

## `app/src/test/java/com/quietrays/tonarc/data/service` (3 files, 363 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [PlaybackTimerControllerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/service/PlaybackTimerControllerTest.kt) | 244 | `class PlaybackTimerControllerTest`, `class FakeAlarmScheduler`, `fun mediaItem`, `fun setUp`, `fun armEndOfTrackTimer`, `fun armCountedPlay` |
| [TaskRemovedPolicyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/service/TaskRemovedPolicyTest.kt) | 47 | `class TaskRemovedPolicyTest`, `fun taskRemoved_continuesPlaybackWhenPlayingAndBackgroundPlaybackEnabled`, `fun taskRemoved_stopsWhenBackgroundPlaybackDisabled`, `fun taskRemoved_stopsWhenNothingIsPlaying`, `fun taskRemoved_stopsWhenIdleAndBackgroundPlaybackDisabled` |
| [TrustedMediaItemsResolutionTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/service/TrustedMediaItemsResolutionTest.kt) | 72 | `class TrustedMediaItemsResolutionTest`, `fun mediaItem` |

## `app/src/test/java/com/quietrays/tonarc/data/service/player` (5 files, 521 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AudioDecoderPolicyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/service/player/AudioDecoderPolicyTest.kt) | 51 | `class AudioDecoderPolicyTest`, `fun selectPlatformDecoders_routesAlacToExtensionRenderer`, `fun selectPlatformDecoders_routesMidiToExtensionRenderer`, `fun selectPlatformDecoders_preservesMedia3OrderForCoreFormats`, `fun isLikelyHardwareDecoder_marksSoftwareRenderersAsSoftware`, `fun isLikelyHardwareDecoder_marksVendorCodecsAsHardware` |
| [AudioFocusResumePolicyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/service/player/AudioFocusResumePolicyTest.kt) | 59 | `class AudioFocusResumePolicyTest`, `fun transientFocusLoss_doesNotResumeWhenPlaybackWasAlreadyPaused`, `fun transientFocusLoss_resumesWhenMasterWasPlaying`, `fun transientFocusLoss_resumesWhenAuxiliaryTransitionWasPlaying`, `fun transientFocusLoss_ignoresPausedAuxiliaryOutsideTransition` |
| [AudioOffloadPolicyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/service/player/AudioOffloadPolicyTest.kt) | 211 | `class AudioOffloadPolicyTest`, `fun defaultPolicy_disablesOffloadForReportedLavaMtkDeviceOnAndroid15`, `fun defaultPolicy_keepsOffloadForPixelOnAndroid15`, `fun defaultPolicy_disablesOffloadForPixelOnSdk37`, `fun defaultPolicy_keepsOffloadForUnrelatedLavaDeviceWithoutMtkSignal`, `fun defaultPolicy_preservesExistingXiaomiAndroid16Disable` |
| [HiResSampleRateCapAudioProcessorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/service/player/HiResSampleRateCapAudioProcessorTest.kt) | 113 | `class HiResSampleRateCapAudioProcessorTest`, `fun configure_keepsSupportedSampleRatesUntouched`, `fun queueInput_downsamples384KhzStereoTo192Khz`, `fun queueInput_carriesPartialFramesAcrossCalls`, `fun queueInput_carriesPartialFloatFramesAcrossCalls`, `fun shortBufferOf` |
| [SurroundDownmixProcessorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/service/player/SurroundDownmixProcessorTest.kt) | 87 | `class SurroundDownmixProcessorTest`, `fun queueInput_downmixes51Pcm16BitToStereo`, `fun queueInput_downmixes71FloatToStereo`, `fun shortBufferOf`, `fun floatBufferOf`, `fun readShorts` |

## `app/src/test/java/com/quietrays/tonarc/data/stats` (1 files, 258 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [PlaybackStatsRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/stats/PlaybackStatsRepositoryTest.kt) | 258 | `class PlaybackStatsRepositoryTest`, `fun createRepository`, `fun song` |

## `app/src/test/java/com/quietrays/tonarc/data/stream` (3 files, 211 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudStreamSecurityIdTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/stream/CloudStreamSecurityIdTest.kt) | 58 | `class CloudStreamSecurityIdTest` |
| [CloudStreamSecurityTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/stream/CloudStreamSecurityTest.kt) | 78 | `class CloudStreamSecurityTest` |
| [StreamDiskCacheTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/stream/StreamDiskCacheTest.kt) | 75 | `class StreamDiskCacheTest`, `fun setUp` |

## `app/src/test/java/com/quietrays/tonarc/data/worker` (3 files, 313 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumGroupingUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/worker/AlbumGroupingUtilsTest.kt) | 155 | `class AlbumGroupingUtilsTest`, `fun testSong` |
| [ArtistParsingUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/worker/ArtistParsingUtilsTest.kt) | 53 | `class ArtistParsingUtilsTest` |
| [SyncWorkerRequestTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/data/worker/SyncWorkerRequestTest.kt) | 105 | `class SyncWorkerRequestTest` |

## `app/src/test/java/com/quietrays/tonarc/presentation/components` (4 files, 323 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExpressiveScrollBarMetricsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/components/ExpressiveScrollBarMetricsTest.kt) | 54 | `class ExpressiveScrollBarMetricsTest`, `fun resolveDragTargetIndex_mapsBottomProgressToLastItem`, `fun extractFastScrollGlyph_skipsPunctuationAndBucketsNumbers`, `fun distanceBeforeIndex_preservesObservedOutlierStrides`, `fun resetIfNeeded_clearsPreviousContentObservations` |
| [LyricsSheetLogicTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/components/LyricsSheetLogicTest.kt) | 202 | `class LyricsSheetLogicTest`, `fun sanitizeSyncedWords_removesLeadingTags_preventsOverlap`, `fun highlightSnapOffsetPx_alignsLineWithHighlightZone`, `fun highlightSnapOffsetPx_clampsWithinViewportForEndOfList`, `fun highlightSnapOffsetPx_handlesOversizedItems`, `fun calculateHighlightMetrics_reservesBottomSpace` |
| [OptimizedAlbumArtTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/components/OptimizedAlbumArtTest.kt) | 26 | `class OptimizedAlbumArtTest`, `fun safeAlbumArtTargetSize_clampsOriginalRequests`, `fun safeAlbumArtTargetSize_keepsBoundedRequests` |
| [PlayerBottomAnchoringTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/components/PlayerBottomAnchoringTest.kt) | 41 | `class PlayerBottomAnchoringTest`, `fun sanitizeNavigationBarBottomInset_clampsImpossibleFloatingWindowInsets`, `fun calculatePlayerSheetCollapsedTargetY_usesMeasuredContainerHeight`, `fun calculatePlayerSheetCollapsedTargetY_neverPlacesSheetOutsideTopEdge` |

## `app/src/test/java/com/quietrays/tonarc/presentation/components/scoped` (1 files, 52 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SheetThemeStateTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/components/scoped/SheetThemeStateTest.kt) | 52 | `class SheetThemeStateTest`, `fun resolvePlayerSheetTargetScheme_withoutAlbumArt_usesSystemScheme`, `fun resolvePlayerSheetTargetScheme_withPendingAlbumPalette_reusesPreviousAlbumScheme`, `fun resolvePlayerSheetTargetScheme_withReadyAlbumPalette_usesCurrentAlbumScheme` |

## `app/src/test/java/com/quietrays/tonarc/presentation/jellyfin/auth` (1 files, 131 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinLoginViewModelTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/jellyfin/auth/JellyfinLoginViewModelTest.kt) | 131 | `class JellyfinLoginViewModelTest`, `fun loginWithLibraries` |

## `app/src/test/java/com/quietrays/tonarc/presentation/library` (1 files, 54 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LibraryTabIdTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/library/LibraryTabIdTest.kt) | 54 | `class LibraryTabIdTest` |

## `app/src/test/java/com/quietrays/tonarc/presentation/screens` (1 files, 51 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LibraryScreenFolderNavigationAnimationTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/screens/LibraryScreenFolderNavigationAnimationTest.kt) | 51 | `class LibraryScreenFolderNavigationAnimationTest` |

## `app/src/test/java/com/quietrays/tonarc/presentation/viewmodel` (10 files, 1,824 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudDownloadsViewModelTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/CloudDownloadsViewModelTest.kt) | 121 | `class CloudDownloadsViewModelTest`, `fun download`, `fun song` |
| [FileExplorerDirectoryMergeTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/FileExplorerDirectoryMergeTest.kt) | 43 | `class FileExplorerDirectoryMergeTest` |
| [ListeningStatsTrackerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/ListeningStatsTrackerTest.kt) | 120 | `class ListeningStatsTrackerTest`, `fun setUp`, `fun tearDown`, `fun song` |
| [LyricsStateHolderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/LyricsStateHolderTest.kt) | 110 | `class LyricsStateHolderTest`, `fun withPersistedLyrics_replacesAlbumArtUriWhenMetadataWriteRefreshesArtworkPath`, `fun withPersistedLyrics_keepsExistingAlbumArtUriWhenMetadataWriteDoesNotReturnOne`, `fun fetchLyricsForSong_usesStoredLyricsWithoutRemoteFetch`, `fun testSong`, `class RecordingLyricsLoadCallback` |
| [PlaybackStateHolderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/PlaybackStateHolderTest.kt) | 172 | `class PlaybackStateHolderTest`, `fun createHolder`, `fun snapshot` |
| [PlayerViewModelHydrationTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/PlayerViewModelHydrationTest.kt) | 72 | `class PlayerViewModelHydrationTest`, `fun withRepositoryHydration_fillsMissingLookupFieldsAndLyrics`, `fun improvesLyricsLookupComparedTo_returnsTrueWhenHydrationAddsLyricsOrPath`, `fun parsePersistedLyrics_returnsParsedLyricsForNonBlankContent`, `fun testSong` |
| [PlayerViewModelTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/PlayerViewModelTest.kt) | 696 | `class PlayerViewModelTest`, `fun setUp`, `fun tearDown`, `fun setupViewModelWithSongs`, `fun stubShuffledPlayback`, `fun PlayerViewModel` |
| [PlaylistViewModelTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/PlaylistViewModelTest.kt) | 74 | `class PlaylistViewModelTest`, `fun setUp`, `fun tearDown` |
| [SearchStateHolderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/SearchStateHolderTest.kt) | 190 | `class SearchStateHolderTest`, `fun setUp`, `fun tearDown` |
| [SetupViewModelTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/presentation/viewmodel/SetupViewModelTest.kt) | 226 | `class SetupViewModelTest`, `fun setUp`, `fun tearDown`, `fun createViewModel` |

## `app/src/test/java/com/quietrays/tonarc/ui/theme` (2 files, 421 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ColorRolesTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/ui/theme/ColorRolesTest.kt) | 295 | `class ColorRolesTest`, `fun generateColorSchemeFromSeed_autoNeutralOutputIsPureGrayscale`, `fun generateColorSchemeFromSeed_keepsStyleSpecificSchemeForMutedGreenSeeds`, `fun selectSeedColorArgbFromPixels_keepsDistinctGreenAlbumsFromCollapsingIntoSharedAccent`, `fun selectSeedColorArgbFromPixels_keepsMostlyNeutralArtworkNearNeutral`, `fun selectSeedColorArgbFromPixels_accuracyZeroMatchesDefaultConfig` |
| [GenreThemeUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/ui/theme/GenreThemeUtilsTest.kt) | 126 | `class GenreThemeUtilsTest`, `fun getGenreDetailColorScheme_usesGenreCardContainerAsSeedInLightTheme`, `fun getGenreDetailColorScheme_usesGenreCardContainerAsSeedInDarkTheme`, `fun getGenreDetailColorScheme_forUnknownGenre_usesMonochromeScheme`, `fun ColorScheme` |

## `app/src/test/java/com/quietrays/tonarc/utils` (12 files, 1,387 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtCacheManagerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/AlbumArtCacheManagerTest.kt) | 70 | `class AlbumArtCacheManagerTest`, `fun snapshotFilesForCleanup_usesStableLastModifiedSnapshots`, `fun snapshotFilesForCleanup_breaksTimestampTiesByPath`, `class FlakyLastModifiedFile` |
| [AlbumArtUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/AlbumArtUtilsTest.kt) | 60 | `class AlbumArtUtilsTest`, `fun findExternalAlbumArtFile_returnsExplicitCoverFromDedicatedAlbumFolder`, `fun findExternalAlbumArtFile_ignoresLooseArtworkNames`, `fun findExternalAlbumArtFile_ignoresGenericDownloadsFolder`, `fun findExternalAlbumArtFile_ignoresStudioGalleryFolder` |
| [AudioMetaUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/AudioMetaUtilsTest.kt) | 35 | `class AudioMetaUtilsTest`, `fun mimeTypeToFormat_mapsM4aVariants`, `fun mimeTypeToFormat_mapsSamsungFormats`, `fun mimeTypeToFormat_mapsUniversalFormats` |
| [DirectoryRuleResolverTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/DirectoryRuleResolverTest.kt) | 53 | `class DirectoryRuleResolverTest`, `fun excludeThenIncludePath_pathBecomesVisibleAgain`, `fun includeThenExcludePath_pathBecomesHidden`, `fun nestedAllow_insideBlockedParent_isRespected`, `fun siblingPath_outsideBlockedTree_staysVisible` |
| [FuzzySearchMatcherTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/FuzzySearchMatcherTest.kt) | 44 | `class FuzzySearchMatcherTest`, `fun testExactMatch`, `fun testTypoTolerance`, `fun testNonMatch`, `fun testDamerauLevenshteinDistance` |
| [LocalArtworkUriTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/LocalArtworkUriTest.kt) | 186 | `class LocalArtworkUriTest`, `fun resolveSongArtworkUri_convertsLegacyLocalCacheUriToStableUri`, `fun resolveSongArtworkUri_convertsSharedArtworkUriToStableUri`, `fun resolveSongArtworkUri_keepsRemoteArtworkUriUntouched`, `fun resolveSongArtworkUri_keepsCloudSourceArtworkUntouched`, `fun parseSongId_readsStableSongUri` |
| [LyricsImportSecurityTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/LyricsImportSecurityTest.kt) | 235 | `class LyricsImportSecurityTest`, `fun validateImportedLyricsFile_acceptsSyncedLrcAndSanitizesControlCharacters`, `fun validateImportedLyricsFile_rejectsUnsupportedExtensions`, `fun validateImportedLyricsFile_rejectsUnsyncedLrcContent`, `fun validateImportedLyricsFile_rejectsOversizedPayloadEvenWithoutReportedSize`, `fun validateLocalLyricsFile_rejectsBinaryPayload` |
| [LyricsUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/LyricsUtilsTest.kt) | 417 | `class LyricsUtilsTest`, `fun parseLyrics_handlesBomAtStartOfSyncedLine`, `fun parseLyrics_handlesWhitespacesBeforeTimestamp`, `fun parseLyrics_parsesFullSampleWithBom`, `fun parseLyrics_ignoresFormatCharactersInsideTimestamp`, `fun parseLyrics_parsesSampleWrappedInQuotes` |
| [MediaItemBuilderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/MediaItemBuilderTest.kt) | 72 | `class MediaItemBuilderTest`, `fun artworkScheme_supportsNavidromeArtworkForInternalPlayback`, `fun artworkScheme_supportsJellyfinArtworkForInternalPlayback`, `fun shouldPreferDirectLocalFileUri_prefersDirectFileUriForLocalM4aMediaStoreItems`, `fun shouldPreferDirectLocalFileUri_keepsContentUriForFormatsThatAlreadySeekCorrectly`, `fun shouldPreferDirectLocalFileUri_keepsCloudUrisUntouched` |
| [MediaStorePermissionHelperTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/MediaStorePermissionHelperTest.kt) | 60 | `class MediaStorePermissionHelperTest`, `fun isMediaStoreItemUriString_acceptsSpecificMediaStoreItems`, `fun isMediaStoreItemUriString_rejectsCollectionUris`, `fun canUseSongIdForMediaStoreRequest_rejectsCloudProviderUris`, `fun canUseSongIdForMediaStoreRequest_acceptsLocalFallbacks` |
| [MediaStoreSelectionUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/MediaStoreSelectionUtilsTest.kt) | 40 | `class MediaStoreSelectionUtilsTest` |
| [QueueUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/quietrays/tonarc/utils/QueueUtilsTest.kt) | 115 | `class QueueUtilsTest`, `fun buildAnchoredShuffleQueueSuspending_handles10kSongsWithoutLosingItems`, `fun buildAnchoredShuffleQueueSuspending_yieldsForLargeQueues`, `fun buildAnchoredShuffleQueueSuspending_startAtZero_placesAnchorFirst`, `fun buildSongs` |

## `assets` (6 files, 3,110 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [icon.png](file:///home/dharshan/PixelPlayerOSS/assets/icon.png) | 131 | - |
| [pixelplayeross_header.png](file:///home/dharshan/PixelPlayerOSS/assets/pixelplayeross_header.png) | 420 | - |
| [screenshot1.jpeg](file:///home/dharshan/PixelPlayerOSS/assets/screenshot1.jpeg) | 592 | - |
| [screenshot2.jpeg](file:///home/dharshan/PixelPlayerOSS/assets/screenshot2.jpeg) | 789 | - |
| [screenshot3.jpeg](file:///home/dharshan/PixelPlayerOSS/assets/screenshot3.jpeg) | 694 | - |
| [screenshot4.jpeg](file:///home/dharshan/PixelPlayerOSS/assets/screenshot4.jpeg) | 484 | - |

## `baselineprofile` (1 files, 48 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [build.gradle.kts](file:///home/dharshan/PixelPlayerOSS/baselineprofile/build.gradle.kts) | 48 | - |

## `baselineprofile/src/main` (1 files, 1 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AndroidManifest.xml](file:///home/dharshan/PixelPlayerOSS/baselineprofile/src/main/AndroidManifest.xml) | 1 | - |

## `baselineprofile/src/main/java/com/lostf1sh/pixelplayeross/baselineprofile` (4 files, 1,207 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BaselineProfileGenerator.kt](file:///home/dharshan/PixelPlayerOSS/baselineprofile/src/main/java/com/lostf1sh/pixelplayeross/baselineprofile/BaselineProfileGenerator.kt) | 622 | `class BaselineProfileGenerator`, `fun generateStartupProfile`, `fun generateBaselineProfile`, `fun MacrobenchmarkScope`, `fun MacrobenchmarkScope`, `fun MacrobenchmarkScope` |
| [BenchmarkEnvironment.kt](file:///home/dharshan/PixelPlayerOSS/baselineprofile/src/main/java/com/lostf1sh/pixelplayeross/baselineprofile/BenchmarkEnvironment.kt) | 126 | `fun benchmarkTargetPackageName`, `fun MacrobenchmarkScope`, `fun MacrobenchmarkScope`, `fun MacrobenchmarkScope`, `fun MacrobenchmarkScope`, `fun MacrobenchmarkScope` |
| [PlayerSheetAnimationBenchmarks.kt](file:///home/dharshan/PixelPlayerOSS/baselineprofile/src/main/java/com/lostf1sh/pixelplayeross/baselineprofile/PlayerSheetAnimationBenchmarks.kt) | 403 | `class PlayerSheetAnimationBenchmarks`, `fun playerSheetOpenCloseGestures`, `fun androidx`, `fun androidx`, `fun androidx`, `fun androidx` |
| [StartupBenchmarks.kt](file:///home/dharshan/PixelPlayerOSS/baselineprofile/src/main/java/com/lostf1sh/pixelplayeross/baselineprofile/StartupBenchmarks.kt) | 56 | `class StartupBenchmarks`, `fun startupCompilationNone`, `fun startupCompilationBaselineProfiles`, `fun startup` |

## `docs` (3 files, 260 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DEPENDENCY_LICENSES.md](file:///home/dharshan/PixelPlayerOSS/docs/DEPENDENCY_LICENSES.md) | 53 | - |
| [FDROID.md](file:///home/dharshan/PixelPlayerOSS/docs/FDROID.md) | 125 | - |
| [RELEASE.md](file:///home/dharshan/PixelPlayerOSS/docs/RELEASE.md) | 82 | - |

## `docs/adr` (2 files, 52 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [0001-youtube-music-streaming-support.md](file:///home/dharshan/PixelPlayerOSS/docs/adr/0001-youtube-music-streaming-support.md) | 30 | - |
| [0002-on-device-recommendations-and-ranking.md](file:///home/dharshan/PixelPlayerOSS/docs/adr/0002-on-device-recommendations-and-ranking.md) | 22 | - |

## `docs/agents` (3 files, 111 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [domain.md](file:///home/dharshan/PixelPlayerOSS/docs/agents/domain.md) | 51 | - |
| [issue-tracker.md](file:///home/dharshan/PixelPlayerOSS/docs/agents/issue-tracker.md) | 45 | - |
| [triage-labels.md](file:///home/dharshan/PixelPlayerOSS/docs/agents/triage-labels.md) | 15 | - |

## `docs/superpowers/plans` (3 files, 263 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [2026-08-20-fuzzy-search-infinite-queue.md](file:///home/dharshan/PixelPlayerOSS/docs/superpowers/plans/2026-08-20-fuzzy-search-infinite-queue.md) | 51 | - |
| [2026-08-21-offline-download-manager.md](file:///home/dharshan/PixelPlayerOSS/docs/superpowers/plans/2026-08-21-offline-download-manager.md) | 70 | - |
| [2026-08-24-rebrand-to-tonarc.md](file:///home/dharshan/PixelPlayerOSS/docs/superpowers/plans/2026-08-24-rebrand-to-tonarc.md) | 142 | - |

## `docs/superpowers/specs` (3 files, 268 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [2026-08-20-fuzzy-search-infinite-queue-design.md](file:///home/dharshan/PixelPlayerOSS/docs/superpowers/specs/2026-08-20-fuzzy-search-infinite-queue-design.md) | 110 | - |
| [2026-08-21-offline-download-manager-design.md](file:///home/dharshan/PixelPlayerOSS/docs/superpowers/specs/2026-08-21-offline-download-manager-design.md) | 83 | - |
| [2026-08-24-rebrand-to-tonarc-design.md](file:///home/dharshan/PixelPlayerOSS/docs/superpowers/specs/2026-08-24-rebrand-to-tonarc-design.md) | 75 | - |

## `fastlane/metadata/android/en-US` (3 files, 18 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [full_description.txt](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/full_description.txt) | 16 | - |
| [short_description.txt](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/short_description.txt) | 1 | - |
| [title.txt](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/title.txt) | 1 | - |

## `fastlane/metadata/android/en-US/changelogs` (3 files, 21 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [1.txt](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/changelogs/1.txt) | 6 | - |
| [2.txt](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/changelogs/2.txt) | 7 | - |
| [3.txt](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/changelogs/3.txt) | 8 | - |

## `fastlane/metadata/android/en-US/images` (1 files, 279 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [icon.png](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/icon.png) | 279 | - |

## `fastlane/metadata/android/en-US/images/phoneScreenshots` (4 files, 2,559 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [1.jpeg](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/phoneScreenshots/1.jpeg) | 592 | - |
| [2.jpeg](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/phoneScreenshots/2.jpeg) | 789 | - |
| [3.jpeg](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/phoneScreenshots/3.jpeg) | 694 | - |
| [4.jpeg](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/phoneScreenshots/4.jpeg) | 484 | - |

## `gradle` (2 files, 229 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [gradle-daemon-jvm.properties](file:///home/dharshan/PixelPlayerOSS/gradle/gradle-daemon-jvm.properties) | 13 | - |
| [libs.versions.toml](file:///home/dharshan/PixelPlayerOSS/gradle/libs.versions.toml) | 216 | - |

## `gradle/wrapper` (2 files, 190 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [gradle-wrapper.jar](file:///home/dharshan/PixelPlayerOSS/gradle/wrapper/gradle-wrapper.jar) | 181 | - |
| [gradle-wrapper.properties](file:///home/dharshan/PixelPlayerOSS/gradle/wrapper/gradle-wrapper.properties) | 9 | - |

## `metadata` (1 files, 59 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [com.lostf1sh.pixelplayeross.yml](file:///home/dharshan/PixelPlayerOSS/metadata/com.lostf1sh.pixelplayeross.yml) | 59 | - |
