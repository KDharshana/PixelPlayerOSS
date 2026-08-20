# PixelPlayerOSS Domain Model & Architecture

A native Material You Android music player supporting offline local playback, gapless audio processing, and multi-source cloud/streaming backends (Navidrome, Jellyfin, YouTube Music).

## Language

**YouTube Music Stream**:
A live-streamed audio track resolved dynamically via client-side Innertube extractor and proxied through `CloudStreamProxy`.
_Avoid_: Web stream, YouTube video, external URL

**Library Source Mode**:
The active filter controlling library display across Local Media, YouTube Music, or Unified mode.
_Avoid_: Tab switch, cloud toggle, account selector

**Hybrid Playlist**:
A playlist containing an arbitrary mix of local audio files, synced YouTube Music tracks, and downloaded cloud media.
_Avoid_: Cloud playlist, multi-source list

**Cloud Track Download**:
An offline cached copy of a remote stream stored on device and played seamlessly via `OfflineTrackDao` without network connection.
_Avoid_: Local cache, YouTube rip, offline save

**Innertube Client**:
The embedded Kotlin client querying YouTube Music's internal API directly without intermediary proxy servers.
_Avoid_: YouTube scraper, bot, backend proxy

**Unified UI Surface**:
The single set of player sheets, widgets, equalizers, carousels, and lyrics components shared identically across local files and cloud streams without visual or functional divergence.
_Avoid_: Dual UI, YouTube mode, streaming player

---

## Codebase Map & Inventory

- **Total Tracked Files**: 1003
- **Total Lines of Code**: 384,938
- **Primary Language**: Kotlin (Android / Jetpack Compose / Media3 / Room / Hilt / Glance)

---

## `[Root]` (15 files, 1,809 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AGENTS.md](file:///home/dharshan/PixelPlayerOSS/AGENTS.md) | 15 | - |
| [CHANGELOG.md](file:///home/dharshan/PixelPlayerOSS/CHANGELOG.md) | 90 | - |
| [CONTRIBUTING.md](file:///home/dharshan/PixelPlayerOSS/CONTRIBUTING.md) | 79 | - |
| [LICENSE](file:///home/dharshan/PixelPlayerOSS/LICENSE) | 674 | - |
| [PRIVACY.md](file:///home/dharshan/PixelPlayerOSS/PRIVACY.md) | 31 | - |
| [README.md](file:///home/dharshan/PixelPlayerOSS/README.md) | 233 | - |
| [SECURITY.md](file:///home/dharshan/PixelPlayerOSS/SECURITY.md) | 15 | - |
| [THIRD_PARTY_NOTICES.md](file:///home/dharshan/PixelPlayerOSS/THIRD_PARTY_NOTICES.md) | 47 | - |
| [build.gradle.kts](file:///home/dharshan/PixelPlayerOSS/build.gradle.kts) | 10 | - |
| [gradle.properties](file:///home/dharshan/PixelPlayerOSS/gradle.properties) | 33 | - |
| [gradlew](file:///home/dharshan/PixelPlayerOSS/gradlew) | 248 | - |
| [gradlew.bat](file:///home/dharshan/PixelPlayerOSS/gradlew.bat) | 82 | - |
| [lint.xml](file:///home/dharshan/PixelPlayerOSS/lint.xml) | 4 | - |
| [settings.gradle.kts](file:///home/dharshan/PixelPlayerOSS/settings.gradle.kts) | 33 | - |
| [skills-lock.json](file:///home/dharshan/PixelPlayerOSS/skills-lock.json) | 215 | - |

## `app` (4 files, 1,037 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [build.gradle.kts](file:///home/dharshan/PixelPlayerOSS/app/build.gradle.kts) | 331 | - |
| [compose_stability.conf](file:///home/dharshan/PixelPlayerOSS/app/compose_stability.conf) | 25 | - |
| [performance_analysis.md](file:///home/dharshan/PixelPlayerOSS/app/performance_analysis.md) | 607 | - |
| [proguard-rules.pro](file:///home/dharshan/PixelPlayerOSS/app/proguard-rules.pro) | 74 | - |

## `app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase` (5 files, 10,648 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [1.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/1.json) | 2010 | - |
| [2.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/2.json) | 2036 | - |
| [3.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/3.json) | 2121 | - |
| [4.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/4.json) | 2180 | - |
| [5.json](file:///home/dharshan/PixelPlayerOSS/app/schemas/com.lostf1sh.pixelplayeross.data.database.PixelPlayerDatabase/5.json) | 2301 | - |

## `app/src/androidTest/java/com/lostf1sh/pixelplayeross/benchmark` (1 files, 24 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [StartupBenchmark.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/lostf1sh/pixelplayeross/benchmark/StartupBenchmark.kt) | 24 | `class StartupBenchmark`, `fun placeholder()`, `class BaselineProfileGenerator`, `fun placeholder()` |

## `app/src/androidTest/java/com/lostf1sh/pixelplayeross/data/database` (1 files, 174 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MusicDaoTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/lostf1sh/pixelplayeross/data/database/MusicDaoTest.kt) | 174 | `class MusicDaoTest`, `fun createDb()`, `fun closeDb()`, `fun createSongEntity()` |

## `app/src/androidTest/java/com/lostf1sh/pixelplayeross/data/service` (1 files, 301 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MusicServiceWorkflowTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/lostf1sh/pixelplayeross/data/service/MusicServiceWorkflowTest.kt) | 301 | `class MusicServiceWorkflowTest`, `interface WorkflowTestEntryPoint`, `fun musicDao()`, `fun setUp()` |

## `app/src/androidTest/java/com/lostf1sh/pixelplayeross/data/worker` (1 files, 175 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SyncWorkerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/lostf1sh/pixelplayeross/data/worker/SyncWorkerTest.kt) | 175 | `class SyncWorkerTest`, `class TestSyncWorkerFactory`, `fun setUp()`, `fun tearDown()`, `class ContextWrapper` |

## `app/src/androidTest/java/com/lostf1sh/pixelplayeross/presentation/components` (1 files, 79 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [WavySliderExpressiveTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/androidTest/java/com/lostf1sh/pixelplayeross/presentation/components/WavySliderExpressiveTest.kt) | 79 | `class WavySliderExpressiveTest`, `fun reportedProgress()`, `fun followsValueAfterBackingStateIsReplaced()`, `fun reportsNonFiniteValueAsZero()` |

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

## `app/src/main` (2 files, 725 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AndroidManifest.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/AndroidManifest.xml) | 241 | - |
| [ic_launcher-playstore.png](file:///home/dharshan/PixelPlayerOSS/app/src/main/ic_launcher-playstore.png) | 484 | - |

## `app/src/main/assets` (1 files, 1 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [vm_new.js](file:///home/dharshan/PixelPlayerOSS/app/src/main/assets/vm_new.js) | 1 | - |

## `app/src/main/assets/licenses` (2 files, 121 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [OFL.txt](file:///home/dharshan/PixelPlayerOSS/app/src/main/assets/licenses/OFL.txt) | 101 | - |
| [THIRD_PARTY_NOTICES.md](file:///home/dharshan/PixelPlayerOSS/app/src/main/assets/licenses/THIRD_PARTY_NOTICES.md) | 20 | - |

## `app/src/main/java/com/lostf1sh/pixelplayeross` (5 files, 1,494 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExternalPlayerActivity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ExternalPlayerActivity.kt) | 151 | `class ExternalPlayerActivity`, `fun handleIntent()`, `fun openFullPlayer()`, `fun resolveStreamUri()` |
| [MainActivity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/MainActivity.kt) | 1134 | `class BottomNavItem`, `class DismissUndoBarSlice`, `class MainActivity`, `fun handleIntent()`, `class NavBarShapeCache`, `class DynamicSmoothCornerShape` |
| [MainActivityIntentContract.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/MainActivityIntentContract.kt) | 7 | `object MainActivityIntentContract` |
| [PixelPlayerApplication.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/PixelPlayerApplication.kt) | 175 | `class PixelPlayerApplication` |
| [ReleaseTree.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ReleaseTree.kt) | 27 | `class ReleaseTree` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data` (2 files, 634 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DailyMixManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/DailyMixManager.kt) | 609 | `class DailyMixManager`, `class SongEngagementStats`, `fun readLegacyEngagementsLocked()`, `fun parseEngagementElement()`, `class RankedSong`, `class DiversityState` |
| [EotStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/EotStateHolder.kt) | 25 | `object EotStateHolder`, `fun setEotTargetSong()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/backup` (2 files, 853 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AppDataBackupManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/AppDataBackupManager.kt) | 497 | `enum class BackupSection`, `enum class BackupOperationType`, `class BackupTransferProgressUpdate`, `class PlaybackHistoryBackupEntry`, `class AppDataBackupPayload`, `class AppDataBackupManager` |
| [BackupManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/BackupManager.kt) | 356 | `class BackupManager`, `fun getBackupHistory()`, `fun discardDecryptedBackup()`, `fun copyLimited()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/format` (5 files, 676 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupCrypto.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/format/BackupCrypto.kt) | 106 | `class BackupEncryptedException`, `class BackupWrongPassphraseException`, `object BackupCrypto`, `fun encryptingStream()` |
| [BackupFormatDetector.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/format/BackupFormatDetector.kt) | 67 | `class BackupFormatDetector`, `enum class Format`, `fun detect()`, `fun readHeader()` |
| [BackupReader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/format/BackupReader.kt) | 279 | `class BackupReader`, `fun detectFormatInternal()`, `fun readManifestFromZip()`, `fun readEntryFromZip()` |
| [BackupWriter.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/format/BackupWriter.kt) | 95 | `class BackupWriter`, `fun sha256()`, `fun countJsonArrayEntries()` |
| [LegacyPayloadAdapter.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/format/LegacyPayloadAdapter.kt) | 129 | `class LegacyPayloadAdapter`, `fun adapt()`, `fun splitLegacyPreferences()`, `fun extractJsonArrayModule()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/history` (1 files, 73 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupHistoryRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/history/BackupHistoryRepository.kt) | 73 | `class BackupHistoryRepository`, `fun readHistory()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/model` (3 files, 203 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupManifest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/model/BackupManifest.kt) | 28 | `class BackupManifest`, `class DeviceInfo`, `class BackupModuleInfo` |
| [BackupModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/model/BackupModels.kt) | 88 | `enum class BackupOperationType`, `class BackupTransferProgressUpdate`, `class PlaybackHistoryBackupEntry`, `class ArtistImageBackupEntry`, `class BackupHistoryEntry`, `class RestorePlan` |
| [BackupSection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/model/BackupSection.kt) | 87 | `enum class BackupSection`, `fun fromKey()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module` (12 files, 1,016 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ArtistImagesModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/ArtistImagesModuleHandler.kt) | 123 | `class ArtistImagesModuleHandler`, `fun readFileAsBase64()` |
| [BackupModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/BackupModuleHandler.kt) | 22 | `interface BackupModuleHandler` |
| [EngagementStatsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/EngagementStatsModuleHandler.kt) | 136 | `class EngagementStatsModuleHandler`, `fun parseEntries()`, `fun parseEntry()`, `fun mergeEntries()` |
| [EqualizerModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/EqualizerModuleHandler.kt) | 52 | `class EqualizerModuleHandler` |
| [FavoritesModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/FavoritesModuleHandler.kt) | 39 | `class FavoritesModuleHandler` |
| [GlobalSettingsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/GlobalSettingsModuleHandler.kt) | 57 | `class GlobalSettingsModuleHandler` |
| [LyricsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/LyricsModuleHandler.kt) | 39 | `class LyricsModuleHandler` |
| [PlaybackHistoryModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/PlaybackHistoryModuleHandler.kt) | 59 | `class PlaybackHistoryModuleHandler` |
| [PlaylistsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/PlaylistsModuleHandler.kt) | 359 | `class PlaylistsModuleHandler`, `fun readFileAsBase64()`, `fun restoreCoverImages()`, `fun resolveSongId()`, `class SongMetadataEntry`, `class PlaylistsBackupPayload` |
| [QuickFillModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/QuickFillModuleHandler.kt) | 52 | `class QuickFillModuleHandler` |
| [SearchHistoryModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/SearchHistoryModuleHandler.kt) | 39 | `class SearchHistoryModuleHandler` |
| [TransitionsModuleHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/module/TransitionsModuleHandler.kt) | 39 | `class TransitionsModuleHandler` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/restore` (2 files, 213 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [RestoreExecutor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/restore/RestoreExecutor.kt) | 157 | `class RestoreExecutor`, `fun reportProgress()` |
| [RestorePlanner.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/restore/RestorePlanner.kt) | 56 | `class RestorePlanner` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/validation` (5 files, 766 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupFileValidator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/validation/BackupFileValidator.kt) | 177 | `class BackupFileValidator`, `fun validate()`, `fun validateZipSafety()`, `fun skipFully()` |
| [ContentSanitizer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/validation/ContentSanitizer.kt) | 36 | `class ContentSanitizer`, `fun sanitizeString()`, `fun sanitizeUrl()`, `fun isValidModuleKey()` |
| [ManifestValidator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/validation/ManifestValidator.kt) | 80 | `class ManifestValidator`, `fun validate()`, `fun verifyChecksum()`, `fun sha256()` |
| [ModuleSchemaValidator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/validation/ModuleSchemaValidator.kt) | 403 | `class ModuleSchemaValidator`, `class NumericFieldResult`, `fun validate()`, `fun validatePlaylistsModule()` |
| [ValidationPipeline.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/backup/validation/ValidationPipeline.kt) | 70 | `class ValidationPipeline`, `fun validateFile()`, `fun validateManifest()`, `fun validateModulePayload()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/database` (38 files, 4,167 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtThemeDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/AlbumArtThemeDao.kt) | 20 | `interface AlbumArtThemeDao` |
| [AlbumArtThemeEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/AlbumArtThemeEntity.kt) | 70 | `class StoredColorSchemeValues`, `class AlbumArtThemeEntity` |
| [AlbumEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/AlbumEntity.kt) | 69 | `class AlbumEntity`, `fun AlbumEntity()`, `fun List()`, `fun Album()` |
| [ArtistEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/ArtistEntity.kt) | 44 | `class ArtistEntity`, `fun ArtistEntity()`, `fun List()`, `fun Artist()` |
| [AudioBookmarkDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/AudioBookmarkDao.kt) | 41 | `interface AudioBookmarkDao`, `fun getAllBookmarksFlow()` |
| [AudioBookmarkEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/AudioBookmarkEntity.kt) | 17 | `class AudioBookmarkEntity` |
| [ColorConverters.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/ColorConverters.kt) | 12 | `fun String()` |
| [EngagementDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/EngagementDao.kt) | 75 | `interface EngagementDao`, `fun getAllEngagementsFlow()` |
| [FavoritesDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/FavoritesDao.kt) | 44 | `interface FavoritesDao`, `fun getFavoriteSongIdsRaw()`, `fun getFavoriteSongIds()` |
| [FavoritesEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/FavoritesEntity.kt) | 22 | `class FavoritesEntity` |
| [FolderSongRow.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/FolderSongRow.kt) | 13 | `class FolderSongRow` |
| [JellyfinDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/JellyfinDao.kt) | 88 | `interface JellyfinDao`, `fun getAllJellyfinSongs()`, `fun getSongsByPlaylist()`, `fun searchSongs()` |
| [JellyfinPlaylistEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/JellyfinPlaylistEntity.kt) | 14 | `class JellyfinPlaylistEntity` |
| [JellyfinSongEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/JellyfinSongEntity.kt) | 83 | `class JellyfinSongEntity`, `fun JellyfinSongEntity()`, `fun JellyfinSong()` |
| [ListenBrainzDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/ListenBrainzDao.kt) | 45 | `interface ListenBrainzDao`, `fun countFlow()` |
| [ListenBrainzPendingListenEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/ListenBrainzPendingListenEntity.kt) | 41 | `class ListenBrainzPendingListenEntity`, `object ListenBrainzSource`, `fun fromSourceType()` |
| [LocalPlaylistDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/LocalPlaylistDao.kt) | 74 | `interface LocalPlaylistDao`, `fun observePlaylistsWithSongs()`, `fun observePlaylistWithSongs()`, `fun observePlaylistSongs()` |
| [LyricsDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/LyricsDao.kt) | 37 | `interface LyricsDao` |
| [LyricsEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/LyricsEntity.kt) | 18 | `class LyricsEntity` |
| [Migrations.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/Migrations.kt) | 155 | `fun SupportSQLiteDatabase()`, `fun SupportSQLiteDatabase()` |
| [MusicDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/MusicDao.kt) | 1995 | `fun buildSongTitleSearchMatchQuery()`, `fun buildSongSearchMatchQuery()`, `class DeviceCapabilitySongRow`, `class LibraryAudioStatsRow`, `class MimeTypeCountRow`, `interface MusicDao` |
| [NavidromeDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/NavidromeDao.kt) | 91 | `interface NavidromeDao`, `fun getAllNavidromeSongs()`, `fun getSongsByPlaylist()`, `fun getLibrarySongCount()` |
| [NavidromePlaylistEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/NavidromePlaylistEntity.kt) | 31 | `class NavidromePlaylistEntity` |
| [NavidromeSongEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/NavidromeSongEntity.kt) | 117 | `class NavidromeSongEntity`, `fun NavidromeSongEntity()`, `fun NavidromeSong()` |
| [OfflineTrackDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/OfflineTrackDao.kt) | 69 | `interface OfflineTrackDao`, `fun observeBySourceUri()`, `fun observeCompleted()`, `fun observeAll()` |
| [OfflineTrackEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/OfflineTrackEntity.kt) | 39 | `class OfflineTrackEntity` |
| [PixelPlayerDatabase.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/PixelPlayerDatabase.kt) | 149 | `class PixelPlayerDatabase`, `fun albumArtThemeDao()`, `fun searchHistoryDao()`, `fun musicDao()` |
| [PlaylistEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/PlaylistEntity.kt) | 84 | `class PlaylistEntity`, `fun PlaylistEntity()`, `fun Playlist()` |
| [PlaylistSongEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/PlaylistSongEntity.kt) | 22 | `class PlaylistSongEntity` |
| [PlaylistWithSongsEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/PlaylistWithSongsEntity.kt) | 15 | `class PlaylistWithSongsEntity` |
| [SearchHistoryDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/SearchHistoryDao.kt) | 34 | `interface SearchHistoryDao` |
| [SearchHistoryEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/SearchHistoryEntity.kt) | 36 | `class SearchHistoryEntity`, `fun SearchHistoryEntity()`, `fun SearchHistoryItem()` |
| [SongArtistCrossRef.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/SongArtistCrossRef.kt) | 87 | `class SongArtistCrossRef`, `class SongWithArtists`, `class ArtistWithSongs`, `class PrimaryArtistInfo` |
| [SongEngagementEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/SongEngagementEntity.kt) | 43 | `class SongEngagementEntity` |
| [SongEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/SongEntity.kt) | 261 | `object SourceType`, `fun fromContentUri()`, `class SongEntity`, `fun SongEntity()`, `class SongSummary` |
| [SongSearchFtsEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/SongSearchFtsEntity.kt) | 18 | `class SongSearchFtsEntity` |
| [TransitionDao.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/TransitionDao.kt) | 67 | `interface TransitionDao`, `fun getPlaylistDefaultRule()`, `fun getSpecificRule()`, `fun getAllRulesForPlaylist()` |
| [TransitionRuleEntity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/database/TransitionRuleEntity.kt) | 27 | `class TransitionRuleEntity` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/diagnostics` (6 files, 1,233 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AdvancedPerformanceDiagnostics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/diagnostics/AdvancedPerformanceDiagnostics.kt) | 238 | `object AdvancedPerformanceDiagnostics`, `object EventTypes`, `class DiagnosticEvent`, `class Snapshot` |
| [AdvancedPerformanceDiagnosticsController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/diagnostics/AdvancedPerformanceDiagnosticsController.kt) | 50 | `class AdvancedPerformanceDiagnosticsController`, `fun start()` |
| [DebugPerformanceReport.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/diagnostics/DebugPerformanceReport.kt) | 348 | `class DebugPerformanceReport`, `fun toJson()`, `fun toPlainText()`, `fun StringBuilder()`, `class DeviceSection`, `class AppSection` |
| [DebugPerformanceReportCollector.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/diagnostics/DebugPerformanceReportCollector.kt) | 276 | `class DebugPerformanceReportCollector`, `class EngineState`, `fun collectDevice()`, `fun collectApp()` |
| [MainThreadStallMonitor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/diagnostics/MainThreadStallMonitor.kt) | 50 | `class MainThreadStallMonitor`, `fun start()`, `fun stop()` |
| [PerformanceMetrics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/diagnostics/PerformanceMetrics.kt) | 271 | `object PerformanceMetrics`, `object Timings`, `object Counters`, `object Maxes`, `class TimingStat`, `class TimingSnapshot` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/equalizer` (3 files, 758 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [EqualizerManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/equalizer/EqualizerManager.kt) | 584 | `class EqualizerManager`, `fun checkDeviceSupport()`, `fun markBassBoostUnavailable()`, `fun markVirtualizerUnavailable()` |
| [EqualizerPreset.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/equalizer/EqualizerPreset.kt) | 97 | `class EqualizerPreset`, `fun custom()`, `fun fromName()` |
| [ExternalAudioEffectSession.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/equalizer/ExternalAudioEffectSession.kt) | 77 | `class ExternalAudioEffectSession`, `fun open()`, `fun close()`, `fun broadcast()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/image` (3 files, 363 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinCoilFetcher.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/image/JellyfinCoilFetcher.kt) | 156 | `class JellyfinCoilFetcher`, `fun shouldLogFailure()`, `fun downloadImage()`, `class Factory` |
| [LocalArtworkCoilFetcher.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/image/LocalArtworkCoilFetcher.kt) | 45 | `class LocalArtworkCoilFetcher`, `class Factory` |
| [NavidromeCoilFetcher.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/image/NavidromeCoilFetcher.kt) | 162 | `class NavidromeCoilFetcher`, `fun shouldLogFailure()`, `class Factory` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin` (2 files, 821 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin/JellyfinRepository.kt) | 753 | `class JellyfinRepository`, `fun createEncryptedPrefs()`, `fun createCredentialPrefs()`, `fun initFromSavedCredentials()` |
| [JellyfinStreamProxy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin/JellyfinStreamProxy.kt) | 68 | `class JellyfinStreamProxy`, `fun resolveJellyfinUri()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin/model` (6 files, 239 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinAlbum.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin/model/JellyfinAlbum.kt) | 31 | `class JellyfinAlbum`, `fun empty()` |
| [JellyfinArtist.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin/model/JellyfinArtist.kt) | 21 | `class JellyfinArtist`, `fun empty()` |
| [JellyfinCredentials.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin/model/JellyfinCredentials.kt) | 74 | `class JellyfinCredentials`, `fun empty()`, `fun connectionValidationError()`, `fun isHttpAllowedHost()` |
| [JellyfinLibrary.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin/model/JellyfinLibrary.kt) | 31 | `class JellyfinLibrary` |
| [JellyfinPlaylist.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin/model/JellyfinPlaylist.kt) | 27 | `class JellyfinPlaylist`, `fun empty()` |
| [JellyfinSong.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/jellyfin/model/JellyfinSong.kt) | 55 | `class JellyfinSong`, `fun empty()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/library` (1 files, 65 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DuplicateFinder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/library/DuplicateFinder.kt) | 65 | `object DuplicateFinder`, `class DuplicateGroup`, `fun normalize()`, `fun findDuplicates()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/listenbrainz` (5 files, 671 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ListenBrainzApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/listenbrainz/ListenBrainzApiService.kt) | 38 | `interface ListenBrainzApiService` |
| [ListenBrainzEndpoint.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/listenbrainz/ListenBrainzEndpoint.kt) | 53 | `class ListenBrainzEndpoint`, `fun setCustom()`, `fun rewrite()`, `fun parseBaseUrl()` |
| [ListenBrainzModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/listenbrainz/ListenBrainzModels.kt) | 113 | `class ListenBrainzSubmission`, `class ListenBrainzListen`, `class ListenBrainzTrackMetadata`, `class ListenBrainzAdditionalInfo`, `class ListenBrainzTokenValidation`, `class ListenBrainzListenCountResponse` |
| [ListenBrainzRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/listenbrainz/ListenBrainzRepository.kt) | 329 | `class InvalidServerUrlException`, `class ListenBrainzRepository`, `fun createEncryptedPrefs()`, `fun createCredentialPrefs()` |
| [ScrobbleManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/listenbrainz/ScrobbleManager.kt) | 138 | `class ScrobbleManager`, `fun onSessionFinalized()`, `fun onPlayingNow()`, `fun meetsListenThreshold()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/media` (9 files, 2,212 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AudioMetadataReader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/media/AudioMetadataReader.kt) | 234 | `class AudioMetadata`, `class AudioMetadataArtwork`, `object AudioMetadataReader`, `fun read()` |
| [AudioMetadataUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/media/AudioMetadataUtils.kt) | 144 | `fun createTempAudioFileFromUri()`, `fun resolveAudioFileExtension()`, `fun normalizeExtension()`, `fun isValidImageData()` |
| [ImageCacheManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/media/ImageCacheManager.kt) | 38 | `class ImageCacheManager`, `fun invalidateCoverArtCaches()` |
| [MediaControllerFactory.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/media/MediaControllerFactory.kt) | 21 | `class MediaControllerFactory`, `fun create()` |
| [MediaMapper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/media/MediaMapper.kt) | 64 | `class MediaMapper`, `fun resolveSongFromMediaItem()` |
| [ReplayGainManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/media/ReplayGainManager.kt) | 155 | `class ReplayGainManager`, `class ReplayGainValues`, `fun getCachedReplayGain()`, `fun readReplayGain()` |
| [SongMetadataEditor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/media/SongMetadataEditor.kt) | 1320 | `enum class MetadataEditError`, `interface ReplayGainUpdate`, `object Keep`, `object Clear`, `class Set`, `class SongMetadataEditor` |
| [TagBpmReader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/media/TagBpmReader.kt) | 181 | `object TagBpmReader`, `fun readBpm()`, `fun readId3v2Bpm()`, `fun parseId3TextFrame()` |
| [TrackBpmRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/media/TrackBpmRepository.kt) | 55 | `class TrackBpmRepository`, `object NoBpm` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/model` (19 files, 1,108 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DirectoryItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/DirectoryItem.kt) | 13 | `class DirectoryItem` |
| [FolderSource.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/FolderSource.kt) | 11 | `enum class FolderSource`, `fun fromStorageKey()` |
| [Genre.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/Genre.kt) | 14 | `class Genre` |
| [LibraryModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/LibraryModels.kt) | 67 | `class Album`, `fun empty()`, `class Artist`, `fun empty()`, `class ArtistRef` |
| [LibraryTabId.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/LibraryTabId.kt) | 27 | `enum class LibraryTabId`, `fun fromStorageKey()`, `fun String()` |
| [Lyrics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/Lyrics.kt) | 33 | `class Lyrics`, `class SyncedLine`, `class SyncedWord` |
| [LyricsSourcePreference.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/LyricsSourcePreference.kt) | 32 | `enum class LyricsSourcePreference`, `fun fromOrdinal()`, `fun fromName()` |
| [MusicFolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/MusicFolder.kt) | 19 | `class MusicFolder` |
| [PlayList.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/PlayList.kt) | 32 | `class Playlist`, `enum class PlaylistShapeType` |
| [PlaybackQueueSnapshot.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/PlaybackQueueSnapshot.kt) | 26 | `class PlaybackQueueItemSnapshot`, `class PlaybackQueueSnapshot` |
| [PlayerInfo.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/PlayerInfo.kt) | 117 | `class QueueItem`, `class WidgetThemeColors`, `class PlayerInfo` |
| [SearchFilterType.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/SearchFilterType.kt) | 12 | `enum class SearchFilterType` |
| [SearchHistoryItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/SearchHistoryItem.kt) | 10 | `class SearchHistoryItem` |
| [SearchResultItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/SearchResultItem.kt) | 11 | `interface SearchResultItem`, `class SongItem`, `class AlbumItem`, `class ArtistItem`, `class PlaylistItem` |
| [SmartPlaylistRule.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/SmartPlaylistRule.kt) | 54 | `enum class SmartPlaylistRule`, `fun fromStorageKey()`, `fun SmartPlaylistRule()`, `fun SmartPlaylistRule()` |
| [Song.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/Song.kt) | 94 | `class Song`, `fun emptySong()` |
| [SortOption.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/SortOption.kt) | 444 | `enum class SortDirection`, `class SortOption`, `object SongDefaultOrder`, `object SongTitleAZ`, `object SongTitleZA`, `object SongArtist` |
| [StorageFilter.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/StorageFilter.kt) | 7 | `enum class StorageFilter` |
| [Transition.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/model/Transition.kt) | 85 | `enum class TransitionMode`, `enum class Curve`, `enum class TransitionSource`, `class TransitionSettings`, `class TransitionResolution`, `class TransitionRule` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/musicbrainz` (2 files, 262 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MusicBrainzApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/musicbrainz/MusicBrainzApiService.kt) | 223 | `class MusicBrainzMatch`, `class MusicBrainzApiService`, `fun buildRecordingQuery()`, `fun escapeLucene()` |
| [MusicBrainzRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/musicbrainz/MusicBrainzRepository.kt) | 39 | `class MusicBrainzRepository` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome` (2 files, 1,134 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/NavidromeRepository.kt) | 1059 | `class NavidromeRepository`, `fun createEncryptedPrefs()`, `fun createCredentialPrefs()`, `fun initFromSavedCredentials()` |
| [NavidromeStreamProxy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/NavidromeStreamProxy.kt) | 75 | `class NavidromeStreamProxy`, `fun resolveNavidromeUri()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/model` (7 files, 370 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeAlbum.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/model/NavidromeAlbum.kt) | 51 | `class NavidromeAlbum`, `fun empty()` |
| [NavidromeArtist.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/model/NavidromeArtist.kt) | 36 | `class NavidromeArtist`, `fun empty()` |
| [NavidromeAuthMethod.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/model/NavidromeAuthMethod.kt) | 24 | `enum class NavidromeAuthMethod`, `fun fromStorageKey()` |
| [NavidromeCredentials.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/model/NavidromeCredentials.kt) | 86 | `class NavidromeCredentials`, `fun empty()`, `fun connectionValidationError()`, `fun isHttpAllowedHost()` |
| [NavidromeMusicFolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/model/NavidromeMusicFolder.kt) | 27 | `class NavidromeMusicFolder`, `fun empty()` |
| [NavidromePlaylist.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/model/NavidromePlaylist.kt) | 51 | `class NavidromePlaylist`, `fun empty()` |
| [NavidromeSong.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/navidrome/model/NavidromeSong.kt) | 95 | `class NavidromeSong`, `fun empty()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/network/deezer` (2 files, 50 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DeezerApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/network/deezer/DeezerApiService.kt) | 23 | `interface DeezerApiService` |
| [DeezerModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/network/deezer/DeezerModels.kt) | 27 | `class DeezerSearchResponse`, `class DeezerArtist` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/network/jellyfin` (2 files, 528 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/network/jellyfin/JellyfinApiService.kt) | 349 | `class JellyfinApiService`, `fun setCredentials()`, `fun clearCredentials()`, `fun hasCredentials()` |
| [JellyfinResponseParser.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/network/jellyfin/JellyfinResponseParser.kt) | 179 | `object JellyfinResponseParser`, `fun parseSong()`, `fun parseSongs()`, `fun parseAlbum()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/network/lyrics` (2 files, 60 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LrcLibApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/network/lyrics/LrcLibApiService.kt) | 43 | `interface LrcLibApiService` |
| [LrcLibResponse.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/network/lyrics/LrcLibResponse.kt) | 17 | `class LrcLibResponse` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/network/navidrome` (2 files, 885 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeApiService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/network/navidrome/NavidromeApiService.kt) | 641 | `class NavidromeApiService`, `fun setCredentials()`, `fun clearCredentials()`, `fun hasCredentials()`, `class SubsonicApiException` |
| [NavidromeResponseParser.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/network/navidrome/NavidromeResponseParser.kt) | 244 | `object NavidromeResponseParser`, `fun parseMusicFolder()`, `fun parseMusicFolders()`, `fun parseArtist()`, `class SearchResults` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/observer` (1 files, 87 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MediaStoreObserver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/observer/MediaStoreObserver.kt) | 87 | `class MediaStoreObserver`, `fun register()`, `fun unregister()`, `fun forceRescan()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/offline` (1 files, 259 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudOfflineRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/offline/CloudOfflineRepository.kt) | 259 | `enum class OfflineDownloadStatus`, `fun fromStorage()`, `class OfflineDownload`, `class CloudOfflineRepository` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/paging` (1 files, 166 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MediaStorePagingSource.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/paging/MediaStorePagingSource.kt) | 166 | `class MediaStorePagingSource`, `fun fetchSongDetails()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist` (3 files, 314 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [M3uManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/M3uManager.kt) | 73 | `class M3uManager`, `fun generateM3u()` |
| [NlpPlaylistGenerator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/NlpPlaylistGenerator.kt) | 146 | `class NlpPlaylistGenerator` |
| [SmartPlaylistBuilder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/SmartPlaylistBuilder.kt) | 95 | `object SmartPlaylistBuilder`, `fun buildSongIds()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/nlp` (7 files, 1,688 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [GenreTaxonomy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/GenreTaxonomy.kt) | 202 | `enum class GenreFamily`, `object GenreTaxonomy`, `class Entry`, `fun resolve()` |
| [LibraryIndex.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/LibraryIndex.kt) | 143 | `class IndexedSong`, `class LibraryIndex`, `fun idf()`, `fun termWeight()` |
| [LocalMetadataHeuristics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/LocalMetadataHeuristics.kt) | 288 | `object LocalMetadataHeuristics`, `fun completeMetadata()`, `fun inferGenre()`, `fun generateTags()`, `class MoodVector` |
| [MoodProfile.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/MoodProfile.kt) | 254 | `enum class MoodKind`, `enum class MoodProfile`, `fun matches()`, `fun matchStrength()` |
| [NlpLexicon.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/NlpLexicon.kt) | 65 | `object NlpLexicon`, `fun isStopWord()`, `fun isNegationCue()` |
| [NlpText.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/NlpText.kt) | 95 | `object NlpText`, `fun normalize()`, `fun tokenize()`, `fun stemTokens()` |
| [PlaylistIntentEngine.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/PlaylistIntentEngine.kt) | 641 | `class SongVibe`, `object PlaylistIntentEngine`, `class ParsedQuery`, `fun parse()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences` (15 files, 2,591 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtColorAccuracy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/AlbumArtColorAccuracy.kt) | 10 | `object AlbumArtColorAccuracy`, `fun clamp()` |
| [AlbumArtPaletteStyle.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/AlbumArtPaletteStyle.kt) | 19 | `enum class AlbumArtPaletteStyle`, `fun fromStorageKey()` |
| [AppLanguage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/AppLanguage.kt) | 45 | `enum class AppLanguage`, `fun getLanguageOptions()`, `fun normalize()` |
| [CarouselStyle.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/CarouselStyle.kt) | 7 | `object CarouselStyle` |
| [CollagePattern.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/CollagePattern.kt) | 20 | `enum class CollagePattern`, `fun fromStorageKey()` |
| [EqualizerPreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/EqualizerPreferencesRepository.kt) | 276 | `class EqualizerPreferencesRepository`, `object Keys` |
| [FullPlayerLoadingTweaks.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/FullPlayerLoadingTweaks.kt) | 15 | `class FullPlayerLoadingTweaks` |
| [LaunchTab.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/LaunchTab.kt) | 7 | `object LaunchTab` |
| [LibraryNavigationMode.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/LibraryNavigationMode.kt) | 6 | `object LibraryNavigationMode` |
| [ListenBrainzPreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/ListenBrainzPreferencesRepository.kt) | 53 | `class ListenBrainzPreferencesRepository`, `object Keys` |
| [NavBarStyle.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/NavBarStyle.kt) | 6 | `object NavBarStyle` |
| [PlaylistPreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/PlaylistPreferencesRepository.kt) | 210 | `class PlaylistPreferencesRepository` |
| [PreferenceBackupEntry.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/PreferenceBackupEntry.kt) | 14 | `class PreferenceBackupEntry` |
| [ThemePreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/ThemePreferencesRepository.kt) | 74 | `class ThemePreferencesRepository`, `object Keys` |
| [UserPreferencesRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/preferences/UserPreferencesRepository.kt) | 1829 | `object ThemePreference`, `object AppThemeMode`, `fun sanitizeNavBarCornerRadius()`, `enum class AlbumArtQuality`, `class AdvancedPerformanceDiagnosticsSettings`, `class UserPreferencesRepository` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/provider` (1 files, 236 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SharedArtworkContentProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/provider/SharedArtworkContentProvider.kt) | 236 | `class SharedArtworkContentProvider`, `fun resolveArtworkFile()`, `fun openCloudArtworkPipe()`, `fun authority()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/repository` (12 files, 4,362 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ArtistImageRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/ArtistImageRepository.kt) | 381 | `class ArtistImageRepository`, `fun calculateCustomImageSampleSize()`, `fun clearCache()`, `fun decodeCustomArtistBitmap()` |
| [AudioBookmarkRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/AudioBookmarkRepository.kt) | 12 | `interface AudioBookmarkRepository`, `fun getAllBookmarksFlow()` |
| [AudioBookmarkRepositoryImpl.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/AudioBookmarkRepositoryImpl.kt) | 27 | `class AudioBookmarkRepositoryImpl` |
| [FolderTreeBuilder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/FolderTreeBuilder.kt) | 274 | `class FolderTreeBuilder`, `fun buildFolderTree()`, `fun buildFolderTreeForRoots()`, `fun buildFolderTreeForRoot()`, `class TempFolder` |
| [LyricsRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/LyricsRepository.kt) | 73 | `interface LyricsRepository`, `fun clearCache()` |
| [LyricsRepositoryImpl.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/LyricsRepositoryImpl.kt) | 1501 | `fun Lyrics()`, `fun parseBestEmbeddedLyricsField()`, `class LyricsData`, `fun hasLyrics()`, `class RemoteSearchStrategy`, `class RemoteSearchBatch` |
| [MediaStoreSongRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/MediaStoreSongRepository.kt) | 553 | `class SearchPrefs`, `class MediaStoreSongRepository`, `fun normalizePath()`, `fun observeSongs()` |
| [MusicRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/MusicRepository.kt) | 346 | `interface MusicRepository`, `fun getAudioFiles()`, `fun getPaginatedSongs()`, `fun getPaginatedAlbums()` |
| [MusicRepositoryImpl.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/MusicRepositoryImpl.kt) | 992 | `class MusicRepositoryImpl`, `fun normalizePath()`, `class CachedDirFilter`, `fun List()`, `class FolderFlowConfig` |
| [SongRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/SongRepository.kt) | 27 | `interface SongRepository`, `fun getSongs()`, `fun getSongsByAlbum()`, `fun getSongsByArtist()` |
| [TransitionRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/TransitionRepository.kt) | 64 | `interface TransitionRepository`, `fun resolveTransitionSettings()`, `fun getAllRulesForPlaylist()`, `fun getPlaylistDefaultRule()` |
| [TransitionRepositoryImpl.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/repository/TransitionRepositoryImpl.kt) | 112 | `class TransitionRepositoryImpl`, `fun TransitionRuleEntity()`, `fun TransitionRule()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/service` (10 files, 3,206 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CoilBitmapLoader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/CoilBitmapLoader.kt) | 67 | `class CoilBitmapLoader`, `fun loadBitmapInternal()` |
| [LocalOnlyMediaNotificationProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/LocalOnlyMediaNotificationProvider.kt) | 57 | `class LocalOnlyMediaNotificationProvider`, `fun setSmallIcon()` |
| [MusicNotificationProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/MusicNotificationProvider.kt) | 21 | `object MusicNotificationProvider` |
| [MusicService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/MusicService.kt) | 2413 | `fun shouldContinuePlaybackAfterTaskRemoved()`, `class MusicService`, `fun markPendingMediaButtonForegroundStart()`, `fun unmarkPendingMediaButtonForegroundStart()` |
| [PixelPlayerMediaButtonReceiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/PixelPlayerMediaButtonReceiver.kt) | 37 | `class PixelPlayerMediaButtonReceiver` |
| [PlaybackActivityTracker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/PlaybackActivityTracker.kt) | 28 | `object PlaybackActivityTracker`, `fun setPlaybackActive()` |
| [PlaybackTimerController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/PlaybackTimerController.kt) | 258 | `interface SleepTimerAlarmScheduler`, `fun schedule()`, `fun cancel()`, `class AlarmManagerSleepTimerScheduler`, `class PlaybackTimerController` |
| [ReplayGainProcessor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/ReplayGainProcessor.kt) | 274 | `class ReplayGainProcessor`, `fun setEnabled()`, `fun setUseAlbumGain()`, `fun captureUserVolume()` |
| [SleepTimerReceiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/SleepTimerReceiver.kt) | 20 | `class SleepTimerReceiver` |
| [TrustedMediaItemsResolution.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/TrustedMediaItemsResolution.kt) | 31 | `class TrustedMediaItemsResolution`, `fun resolveMediaItemsWithTrustedArtworkGrants()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player` (9 files, 2,616 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AudioDecoderPolicy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player/AudioDecoderPolicy.kt) | 50 | `object AudioDecoderPolicy`, `fun shouldUseExtensionRenderer()`, `fun isLikelyHardwareDecoder()` |
| [DualPlayerEngine.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player/DualPlayerEngine.kt) | 1368 | `class ActiveDecoderInfo`, `fun shouldResumeAfterTransientAudioFocusLoss()`, `fun shouldDisableAudioOffloadByDefaultForDevice()`, `fun shouldTriggerAudioOffloadStallFallback()`, `class DualPlayerEngine`, `class TransitionTarget` |
| [FadingPlayer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player/FadingPlayer.kt) | 95 | `class FadingPlayer` |
| [HiFiCapabilityChecker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player/HiFiCapabilityChecker.kt) | 68 | `object HiFiCapabilityChecker`, `fun isSupported()`, `fun runCheck()` |
| [HiResSampleRateCapAudioProcessor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player/HiResSampleRateCapAudioProcessor.kt) | 271 | `class HiResSampleRateCapAudioProcessor`, `fun process16Bit()`, `fun processFloat()`, `fun processableFrameCount()` |
| [MappingPlayer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player/MappingPlayer.kt) | 81 | `class MappingPlayer`, `fun mapMediaItem()` |
| [SmartCrossfadePlanner.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player/SmartCrossfadePlanner.kt) | 140 | `enum class BpmCompatibility`, `class SmartCrossfadePlan`, `object SmartCrossfadePlanner`, `fun foldedTempoRatio()` |
| [SurroundDownmixProcessor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player/SurroundDownmixProcessor.kt) | 206 | `class SurroundDownmixProcessor`, `fun ensureOutputBuffer()`, `fun downmix51Left()`, `fun downmix51Right()` |
| [TransitionController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/player/TransitionController.kt) | 337 | `class TransitionSettingsSnapshot`, `class TransitionController`, `fun initialize()`, `fun scheduleTransitionFor()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/service/tile` (3 files, 231 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LastPlaylistTileService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/tile/LastPlaylistTileService.kt) | 163 | `class LastPlaylistTileService`, `interface LastPlaylistTileEntryPoint`, `fun musicRepository()`, `fun playlistPreferencesRepository()` |
| [ShuffleAllTileService.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/tile/ShuffleAllTileService.kt) | 41 | `class ShuffleAllTileService` |
| [TileServiceCompat.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/service/tile/TileServiceCompat.kt) | 27 | `fun TileService()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/stats` (1 files, 1,112 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [PlaybackStatsRepository.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/stats/PlaybackStatsRepository.kt) | 1112 | `class PlaybackStatsRepository`, `class PlaybackEvent`, `class PlaybackHistoryEntry`, `class SongPlaybackSummary`, `class ArtistPlaybackSummary`, `class GenrePlaybackSummary` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/stream` (3 files, 556 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudMusicUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/stream/CloudMusicUtils.kt) | 27 | `class BulkSyncResult`, `object CloudMusicUtils`, `fun parseArtistNames()` |
| [CloudStreamProxy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/stream/CloudStreamProxy.kt) | 338 | `class CloudStreamProxy`, `fun parseRouteParam()`, `fun validateId()`, `fun formatIdForUrl()`, `class CachedUrl` |
| [CloudStreamSecurity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/stream/CloudStreamSecurity.kt) | 191 | `object CloudStreamSecurity`, `class RangeHeaderValidation`, `fun validateNavidromeSongId()`, `fun validateJellyfinItemId()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/data/worker` (10 files, 2,540 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumGroupingUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/AlbumGroupingUtils.kt) | 164 | `class AlbumGroupingKey`, `fun resolveAlbumArtist()`, `fun buildAlbumGroupingKey()`, `fun buildAlbumGroupingKeys()` |
| [ArtistParsingUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/ArtistParsingUtils.kt) | 54 | `fun collectArtistNames()`, `fun choosePreferredArtistName()` |
| [CloudSyncCoordinator.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/CloudSyncCoordinator.kt) | 68 | `class CloudSyncCoordinator` |
| [CloudTrackDownloadWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/CloudTrackDownloadWorker.kt) | 286 | `class CloudTrackDownloadWorker`, `fun resolveSource()`, `fun extensionFor()`, `class DownloadSource`, `class DownloadHttpException`, `class StaleDownloadAttemptException` |
| [JellyfinSyncWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/JellyfinSyncWorker.kt) | 40 | `class JellyfinSyncWorker`, `fun startAllSync()` |
| [NavidromeSyncWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/NavidromeSyncWorker.kt) | 83 | `class NavidromeSyncWorker`, `fun startAllSync()`, `fun startPlaylistSync()` |
| [ScrobbleFlushWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/ScrobbleFlushWorker.kt) | 121 | `class ScrobbleFlushWorker`, `fun request()` |
| [SyncExecutionPlan.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/SyncExecutionPlan.kt) | 60 | `enum class LocalScanMode`, `class SyncExecutionPlan`, `fun buildSyncExecutionPlan()`, `fun incrementalFetchTimestampSeconds()` |
| [SyncManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/SyncManager.kt) | 428 | `class SyncProgress`, `enum class SyncPhase`, `class SyncManager`, `fun start()` |
| [SyncWorker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/data/worker/SyncWorker.kt) | 1236 | `enum class SyncMode`, `class SyncWorker`, `fun hasMediaReadPermission()`, `class MultiArtistProcessResult`, `class RawSongData` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/di` (5 files, 705 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AppModule.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/di/AppModule.kt) | 508 | `object AppModule` |
| [BackupModule.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/di/BackupModule.kt) | 74 | `object BackupModule` |
| [DispatcherProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/di/DispatcherProvider.kt) | 37 | `interface DispatcherProvider`, `class DefaultDispatcherProvider`, `class DispatcherModule`, `fun bindDispatcherProvider()` |
| [NetworkModule.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/di/NetworkModule.kt) | 48 | `object NetworkModule` |
| [Qualifiers.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/di/Qualifiers.kt) | 38 | - |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components` (69 files, 26,028 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtCollage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/AlbumArtCollage.kt) | 145 | `class Config`, `fun AlbumArtCollage()` |
| [AlbumCarouselSelection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/AlbumCarouselSelection.kt) | 201 | `fun rememberRoundedParallaxCarouselState()`, `fun AlbumCarouselSection()`, `fun resolveCurrentQueueIndex()`, `fun buildQueueOccurrenceKeys()` |
| [AlbumMultiSelectionOptionSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/AlbumMultiSelectionOptionSheet.kt) | 265 | `fun AlbumMultiSelectionOptionSheet()`, `fun AlbumSelectionActionButton()`, `fun StackedAlbumCovers()` |
| [AllFilesAccessDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/AllFilesAccessDialog.kt) | 31 | `fun AllFilesAccessDialog()` |
| [AppRebrandDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/AppRebrandDialog.kt) | 67 | `fun AppRebrandDialog()` |
| [AppSidebarDrawer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/AppSidebarDrawer.kt) | 191 | `class DrawerDestination`, `object Home`, `object Equalizer`, `object Settings` |
| [BackupModuleSelectionDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/BackupModuleSelectionDialog.kt) | 568 | `fun BackupModuleSelectionDialog()`, `fun closeDialog()`, `fun BackupSectionSelectableCardShared()` |
| [BetaInfoBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/BetaInfoBottomSheet.kt) | 694 | `fun BetaInfoBottomSheet()`, `fun GitHubReportCard()`, `fun BetaFaqSection()`, `fun BetaCardSurface()` |
| [ChangelogBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ChangelogBottomSheet.kt) | 314 | `class ChangelogSection`, `class ChangelogVersion`, `fun changelogVersions()`, `fun ChangelogBottomSheet()` |
| [CloudLibraryPickerSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/CloudLibraryPickerSheet.kt) | 254 | `class CloudLibraryPickerItem`, `fun CloudLibraryPickerSheet()`, `fun CloudLibrarySelectorChoice()` |
| [CollagePatterns.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/CollagePatterns.kt) | 68 | `fun buildCollageConfigs()`, `fun cosmicSwirlConfigs()`, `fun honeycombGrooveConfigs()`, `fun vinylStackConfigs()` |
| [CollapsibleCommonTopBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/CollapsibleCommonTopBar.kt) | 136 | `fun CollapsibleCommonTopBar()` |
| [CrashReportDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/CrashReportDialog.kt) | 199 | `fun CrashReportDialog()` |
| [CustomPresetsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/CustomPresetsSheet.kt) | 182 | `fun CustomPresetsSheet()`, `fun CustomPresetItem()` |
| [DailyMixSection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/DailyMixSection.kt) | 439 | `fun DailyMixSection()`, `fun DailyMixCard()`, `fun DailyMixHeader()`, `fun shapeConditionalModifier()` |
| [DismissUndoBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/DismissUndoBar.kt) | 127 | `fun DismissUndoBar()` |
| [EditMultipleSongsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/EditMultipleSongsSheet.kt) | 649 | `class MixedValueField`, `fun EditMultipleSongsSheet()`, `fun EditMultipleSongsContent()`, `fun BatchEditField()` |
| [EditSongSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/EditSongSheet.kt) | 1123 | `fun formatReplayGainForInput()`, `fun EditSongSheet()`, `fun EditSongContent()`, `fun CoverArtEditorCard()`, `class CoverArtCropResult` |
| [ExpressiveScrollBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ExpressiveScrollBar.kt) | 738 | `class ScrollMetrics`, `class VisibleGridLineMetrics`, `fun estimateListFallbackStridePx()`, `fun observeListLayoutMetrics()` |
| [ExpressiveScrollBarLabelResolvers.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ExpressiveScrollBarLabelResolvers.kt) | 52 | `fun songFastScrollLabel()`, `fun albumFastScrollLabel()`, `fun artistFastScrollLabel()`, `fun playlistFastScrollLabel()` |
| [ExpressiveScrollBarMetrics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ExpressiveScrollBarMetrics.kt) | 147 | `class AxisObservationTracker`, `fun resetIfNeeded()`, `fun observeRepresentativeSample()`, `fun observeItemSize()` |
| [ExpressiveTopBarContent.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ExpressiveTopBarContent.kt) | 198 | `fun ExpressiveTopBarContent()`, `fun rememberRoundedFlexFontFamily()` |
| [FileExplorerBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/FileExplorerBottomSheet.kt) | 805 | `fun FileExplorerDialog()`, `fun FileExplorerContent()`, `fun ExplorerEmptyState()`, `fun ExplorerLoadingState()` |
| [GenreSortBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/GenreSortBottomSheet.kt) | 188 | `fun GenreSortBottomSheet()`, `fun SortOptionCard()` |
| [GradientTopBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/GradientTopBar.kt) | 197 | `fun GenreGradientTopBar()`, `fun HomeGradientTopBar()` |
| [HomeOptionsBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/HomeOptionsBottomSheet.kt) | 38 | `fun HomeOptionsBottomSheet()` |
| [ImageCropView.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ImageCropView.kt) | 120 | `fun ImageCropView()` |
| [LibrarySortBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/LibrarySortBottomSheet.kt) | 445 | `fun LibrarySortBottomSheet()`, `fun LibrarySheetSortDirectionCard()`, `fun LibrarySheetToggleCard()` |
| [LyricsFloatingToolbar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/LyricsFloatingToolbar.kt) | 162 | `fun LyricsFloatingToolbar()` |
| [LyricsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/LyricsSheet.kt) | 1987 | `class LyricsSheetColors`, `fun lyricsSheetColors()`, `fun preferredContrastColor()`, `fun contrastRatio()`, `class SyncedWordCluster`, `class HighlightZoneMetrics` |
| [LyricsSyncControls.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/LyricsSyncControls.kt) | 125 | `fun LyricsSyncControls()`, `fun androidx()` |
| [MarqueeText.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/MarqueeText.kt) | 187 | `fun AutoScrollingTextOnDemand()`, `fun AutoScrollingText()` |
| [MultiSelectionBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/MultiSelectionBottomSheet.kt) | 518 | `fun MultiSelectionBottomSheet()`, `fun StackedAlbumArts()` |
| [NoInternetComponents.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/NoInternetComponents.kt) | 116 | `fun NoInternetDialog()`, `fun NoInternetScreen()` |
| [OptimizedAlbumArt.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/OptimizedAlbumArt.kt) | 253 | `fun OptimizedAlbumArt()`, `fun PlaceholderContent()`, `fun renderDirectAlbumArt()`, `fun safeAlbumArtTargetSize()` |
| [PermissionIconCollage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/PermissionIconCollage.kt) | 102 | `class IconConfig`, `fun PermissionIconCollage()` |
| [PlayerInternalNavigationBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/PlayerInternalNavigationBar.kt) | 241 | `fun sanitizeNavigationBarBottomInset()`, `fun calculatePlayerSheetCollapsedTargetY()`, `fun resolveNavBarContentHeight()`, `fun resolveMainScreenBottomGradientHeight()` |
| [PlayerNavigationRail.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/PlayerNavigationRail.kt) | 125 | `fun PlayerNavigationRail()` |
| [PlaylistArtCollage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/PlaylistArtCollage.kt) | 218 | `fun PlaylistArtCollage()` |
| [PlaylistBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/PlaylistBottomSheet.kt) | 246 | `fun PlaylistBottomSheet()` |
| [PlaylistContainer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/PlaylistContainer.kt) | 578 | `fun PlaylistContainer()`, `fun PlaylistItems()`, `fun PlaylistItem()`, `fun CreatePlaylistDialogRedesigned()` |
| [PlaylistCover.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/PlaylistCover.kt) | 132 | `fun PlaylistCover()`, `fun getIconByName()` |
| [PlaylistCreationDialogs.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/PlaylistCreationDialogs.kt) | 430 | `fun PlaylistCreationTypeDialog()`, `fun DescribePlaylistDialog()`, `fun CreationModeCard()` |
| [PlaylistMultiSelectionBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/PlaylistMultiSelectionBottomSheet.kt) | 377 | `fun PlaylistMultiSelectionBottomSheet()`, `fun StackedPlaylistCovers()`, `fun getPlaylistIconByName()` |
| [QueueBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/QueueBottomSheet.kt) | 2088 | `class QueueUndoBarProjection`, `fun PlayerUiState()`, `fun QueueBottomSheet()`, `fun activeQueueIndexAt()` |
| [RecentlyPlayedRangeSelector.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/RecentlyPlayedRangeSelector.kt) | 169 | `fun RecentlyPlayedRangeSelector()`, `fun RecentlyPlayedRangeChip()` |
| [RecentlyPlayedSection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/RecentlyPlayedSection.kt) | 352 | `class RecentlyPlayedPillCell`, `class RecentlyPlayedPillRow`, `fun RecentlyPlayedSection()`, `fun buildRecentlyPlayedPillRows()` |
| [ReorderPresetsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ReorderPresetsSheet.kt) | 397 | `fun ReorderPresetsSheet()`, `class PresetItem`, `fun togglePin()` |
| [ReorderTabsSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ReorderTabsSheet.kt) | 288 | `fun ReorderTabsSheet()`, `fun FloatingToolBar()` |
| [RoundedParallaxCarousell.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/RoundedParallaxCarousell.kt) | 1481 | `class CarouselState`, `fun rememberCarouselState()`, `fun RoundedHorizontalMultiBrowseCarousel()`, `fun RoundedCarousel()`, `class CarouselPageSize`, `interface CarouselItemScope` |
| [SavePresetDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/SavePresetDialog.kt) | 144 | `fun SavePresetDialog()`, `fun RenamePresetDialog()` |
| [ScreenWrapper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ScreenWrapper.kt) | 133 | `fun ScreenWrapper()` |
| [SheetStates.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/SheetStates.kt) | 29 | `fun rememberModalSheetState()` |
| [ShimmerBox.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ShimmerBox.kt) | 45 | `fun ShimmerBox()` |
| [SmartImage.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/SmartImage.kt) | 265 | `fun SmartImage()`, `fun handleDirectModel()`, `fun Placeholder()` |
| [SongInfoBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/SongInfoBottomSheet.kt) | 1321 | `fun SongInfoBottomSheet()`, `fun requestToneSystemWritePermission()`, `fun handleToneResult()`, `fun setCurrentSongAsTone()` |
| [SongPickerBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/SongPickerBottomSheet.kt) | 884 | `fun SongPickerBottomSheet()`, `fun SongPickerContent()`, `fun SongPickerSelectionPane()`, `fun SongPickerSearchField()` |
| [StatsOverviewCard.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/StatsOverviewCard.kt) | 325 | `fun StatsOverviewCard()`, `fun OverviewContent()`, `fun PlaceholderOverviewContent()`, `fun MiniListeningTimeline()` |
| [StreamingProviderSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/StreamingProviderSheet.kt) | 242 | `fun StreamingProviderSheet()`, `fun ProviderRow()` |
| [SyncProgressBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/SyncProgressBar.kt) | 193 | `fun SyncProgressBar()`, `fun getPhaseText()`, `fun CompactSyncProgressIndicator()` |
| [TimerOptionsBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/TimerOptionsBottomSheet.kt) | 443 | `fun TimerOptionsBottomSheet()` |
| [ToggleSegmentButton.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/ToggleSegmentButton.kt) | 219 | `fun ToggleSegmentButton()`, `fun ToggleSegmentButton()`, `fun ToggleSegmentButton()`, `fun ToggleSegmentButton()` |
| [UnifiedPlayerOverlaysLayer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/UnifiedPlayerOverlaysLayer.kt) | 454 | `class SaveQueueOverlayData`, `fun UnifiedPlayerQueueLayer()`, `fun UnifiedPlayerSongInfoLayer()`, `fun UnifiedPlayerQueueAndSongInfoHost()` |
| [UnifiedPlayerSheetLayers.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/UnifiedPlayerSheetLayers.kt) | 321 | `fun BoxScope()`, `fun UnifiedPlayerPrewarmLayer()` |
| [UnifiedPlayerSheetShared.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/UnifiedPlayerSheetShared.kt) | 225 | `fun getNavigationBarHeight()`, `fun MiniPlayerContentInternal()` |
| [UnifiedPlayerSheetV2.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/UnifiedPlayerSheetV2.kt) | 723 | `class PlayerUiSheetSliceV2`, `fun UnifiedPlayerSheetV2()` |
| [WavyArcSlider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/WavyArcSlider.kt) | 207 | `fun WavyArcSlider()`, `fun mapTouchToValue()`, `fun dispatchValue()` |
| [WavyMusicSlider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/WavyMusicSlider.kt) | 338 | `fun WavyMusicSlider()`, `fun yAt()` |
| [WavySliderExpressive.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/WavySliderExpressive.kt) | 364 | `fun normalizeValue()`, `fun WavySliderExpressive()`, `fun lerp()`, `fun valueForX()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/brickbreaker` (1 files, 999 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BrickBreakerOverlay.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/brickbreaker/BrickBreakerOverlay.kt) | 999 | `enum class BrickType`, `class BrickState`, `class Particle`, `fun BrickBreakerOverlay()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/external` (1 files, 371 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExternalPlayerOverlay.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/external/ExternalPlayerOverlay.kt) | 371 | `fun ExternalPlayerOverlay()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/player` (6 files, 3,481 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AddBookmarkDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/player/AddBookmarkDialog.kt) | 262 | `fun AddBookmarkDialog()`, `fun resolveLyricBookmarkTitle()` |
| [AnimatedPlaybackControls.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/player/AnimatedPlaybackControls.kt) | 223 | `enum class PlaybackButtonType`, `fun AnimatedPlaybackControls()`, `fun weightFor()` |
| [BottomToggleRow.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/player/BottomToggleRow.kt) | 121 | `fun BottomToggleRow()` |
| [FullPlayerContent.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/player/FullPlayerContent.kt) | 2493 | `enum class SkipDirection`, `fun FullPlayerContent()`, `fun predictSkipCarouselIndex()`, `fun requestSkip()`, `class DelayedContentFrame`, `class TransportButtonColors` |
| [MorphingPlayPauseIcon.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/player/MorphingPlayPauseIcon.kt) | 97 | `fun quad()`, `fun MorphingPlayPauseIcon()` |
| [PlayerArtistPickerBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/player/PlayerArtistPickerBottomSheet.kt) | 285 | `class PlayerArtistShortcutItem`, `fun PlayerArtistPickerBottomSheet()`, `fun PlayerArtistShortcutCard()`, `fun artistShortcutShape()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped` (28 files, 2,852 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ComposeLoader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/ComposeLoader.kt) | 109 | `fun DeferAt()`, `fun DeferUntil()`, `fun rememberSmoothProgress()`, `fun sampleNow()` |
| [CustomNavigationBarItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/CustomNavigationBarItem.kt) | 194 | `fun RowScope()` |
| [Expansion.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/Expansion.kt) | 9 | `fun rememberExpansionTransition()` |
| [FullPlayerCompositionPolicy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/FullPlayerCompositionPolicy.kt) | 73 | `class FullPlayerCompositionPolicy`, `fun rememberFullPlayerCompositionPolicy()` |
| [FullPlayerRuntimePolicy.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/FullPlayerRuntimePolicy.kt) | 48 | `class FullPlayerRuntimePolicy`, `fun rememberFullPlayerRuntimePolicy()` |
| [FullPlayerVisualState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/FullPlayerVisualState.kt) | 41 | `class FullPlayerVisualState`, `fun rememberFullPlayerVisualState()` |
| [KeylineListScope.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/KeylineListScope.kt) | 2 | - |
| [LyricsPredictiveBackHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/LyricsPredictiveBackHandler.kt) | 51 | `fun LyricsPredictiveBackHandler()` |
| [MiniPlayerDismissGestureHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/MiniPlayerDismissGestureHandler.kt) | 177 | `enum class MiniDismissDragPhase`, `class MiniPlayerDismissGestureHandler`, `fun onDragStart()`, `fun onHorizontalDrag()` |
| [PlayerAlbumNavigationEffect.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/PlayerAlbumNavigationEffect.kt) | 32 | `fun PlayerAlbumNavigationEffect()` |
| [PlayerArtistNavigationEffect.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/PlayerArtistNavigationEffect.kt) | 33 | `fun PlayerArtistNavigationEffect()` |
| [PlayerSheetPredictiveBackHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/PlayerSheetPredictiveBackHandler.kt) | 79 | `fun PlayerSheetPredictiveBackHandler()` |
| [PrefetchAlbumNeighbors.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/PrefetchAlbumNeighbors.kt) | 103 | `fun PrefetchAlbumNeighborsImg()`, `fun PrefetchAlbumNeighbors()` |
| [PrewarmFullPlayerState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/PrewarmFullPlayerState.kt) | 40 | `fun rememberPrewarmFullPlayer()` |
| [QueueItemDismissGestureHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/QueueItemDismissGestureHandler.kt) | 213 | `enum class QueueDismissDragPhase`, `class QueueItemDismissGestureHandler`, `fun onDragStart()`, `fun onHorizontalDrag()` |
| [QueueSheetController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/QueueSheetController.kt) | 179 | `class QueueSheetController`, `fun resetDragPipeline()`, `fun launchDragSnapLoopIfNeeded()`, `fun animate()` |
| [QueueSheetRuntimeEffects.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/QueueSheetRuntimeEffects.kt) | 52 | `fun QueueSheetRuntimeEffects()` |
| [QueueSheetState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/QueueSheetState.kt) | 97 | `class QueueSheetState`, `fun rememberQueueSheetState()` |
| [SheetActionHandlers.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetActionHandlers.kt) | 139 | `class SheetActionHandlers`, `fun rememberSheetActionHandlers()` |
| [SheetBackAndDragState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetBackAndDragState.kt) | 56 | `class SheetBackAndDragState`, `fun rememberSheetBackAndDragState()` |
| [SheetInteractionState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetInteractionState.kt) | 165 | `class SheetInteractionState`, `fun rememberSheetInteractionState()`, `class PlayerSheetDynamicShape`, `fun Dp()` |
| [SheetModalOverlayController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetModalOverlayController.kt) | 74 | `class SheetModalOverlayController`, `fun updateSelectedSongForInfo()`, `fun dismissSaveQueueOverlay()`, `fun launchSaveQueueOverlay()` |
| [SheetMotionController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetMotionController.kt) | 87 | `class SheetMotionController` |
| [SheetOverlayState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetOverlayState.kt) | 90 | `class SheetOverlayState`, `fun rememberSheetOverlayState()` |
| [SheetThemeState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetThemeState.kt) | 226 | `class SheetThemeState`, `fun resolvePlayerSheetTargetScheme()`, `fun rememberSheetThemeState()`, `fun rememberBatchAnimatedColorScheme()` |
| [SheetVerticalDragGestureHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetVerticalDragGestureHandler.kt) | 171 | `class SheetVerticalDragGestureHandler`, `fun onDragStart()`, `fun onVerticalDrag()`, `fun onDragEnd()` |
| [SheetVerticalDragMath.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetVerticalDragMath.kt) | 69 | `class SheetVerticalDragFrame`, `fun computeSheetVerticalDragFrame()`, `fun resolveVerticalSheetTargetState()`, `fun collapseSpringDampingForFraction()` |
| [SheetVisualState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetVisualState.kt) | 243 | `class SheetVisualState`, `fun rememberSheetVisualState()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/snapping` (1 files, 400 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LazyListSnapper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/snapping/LazyListSnapper.kt) | 400 | `object SnapperFlingBehaviorDefaults`, `class SnapperLayoutInfo`, `fun determineTargetIndex()`, `fun distanceToIndexSnap()`, `class SnapperLayoutItemInfo`, `class LazyListSnapperLayoutInfo` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps` (15 files, 3,457 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AutoSizingText.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/AutoSizingText.kt) | 149 | `fun AutoSizingTextToFill()` |
| [AutoSizingTextGlance.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/AutoSizingTextGlance.kt) | 129 | `fun AutoSizingTextGlance()` |
| [EnhancedSongListItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/EnhancedSongListItem.kt) | 409 | `class EnhancedSongAnimationTarget`, `fun lerpFloat()`, `fun EnhancedSongListItem()` |
| [ExpressiveSongListItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/ExpressiveSongListItem.kt) | 113 | `fun ExpressiveSongListItem()` |
| [FetchLyricsDialog.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/FetchLyricsDialog.kt) | 595 | `fun FetchLyricsDialog()`, `fun IdleContent()`, `fun LoadingContent()`, `fun PickResultContent()` |
| [LibraryActionRow.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/LibraryActionRow.kt) | 502 | `fun LibraryActionRow()`, `fun Breadcrumbs()` |
| [LyricsMoreBottomSheet.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/LyricsMoreBottomSheet.kt) | 553 | `fun LyricsMoreBottomSheet()` |
| [MaterialYouVectorDrawable.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/MaterialYouVectorDrawable.kt) | 53 | `fun MaterialYouVectorDrawable()`, `fun Context()` |
| [PlayerProgressBarSection.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/PlayerProgressBarSection.kt) | 2 | - |
| [PlayerSeekBar.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/PlayerSeekBar.kt) | 126 | `fun PlayerSeekBar()` |
| [PlayingEqIcon.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/PlayingEqIcon.kt) | 108 | `fun PlayingEqIcon()` |
| [SelectionActionRow.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/SelectionActionRow.kt) | 236 | `fun SelectionActionRow()`, `fun SelectionCountPill()` |
| [SelectionHeader.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/SelectionHeader.kt) | 257 | `fun SelectionHeader()`, `fun StackedCoverArts()` |
| [SineWaveLine.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/SineWaveLine.kt) | 111 | `fun SineWaveLine()` |
| [TightWrapText.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/components/subcomps/TightWrapText.kt) | 114 | `fun TightWrapText()`, `class TextLayoutContainer` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/jellyfin/auth` (2 files, 650 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinLoginActivity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/jellyfin/auth/JellyfinLoginActivity.kt) | 540 | `class JellyfinLoginActivity`, `fun JellyfinLoginScreen()`, `fun JellyfinLoginField()` |
| [JellyfinLoginViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/jellyfin/auth/JellyfinLoginViewModel.kt) | 110 | `interface JellyfinLoginState`, `object Idle`, `object Loading`, `class SelectLibraries`, `class Success`, `class Error` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/jellyfin/dashboard` (2 files, 977 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinDashboardScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/jellyfin/dashboard/JellyfinDashboardScreen.kt) | 818 | `fun JellyfinDashboardScreen()`, `fun JellyfinDashboardContent()`, `fun JellyfinMenuCard()`, `fun JellyfinLibrarySummaryPanel()` |
| [JellyfinDashboardViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/jellyfin/dashboard/JellyfinDashboardViewModel.kt) | 159 | `class JellyfinDashboardViewModel`, `fun loadLibraries()`, `fun setSelectedLibraryIds()`, `fun syncAllPlaylistsAndSongs()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/model` (3 files, 319 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LibraryTabId.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/model/LibraryTabId.kt) | 110 | `enum class LibraryTabId`, `fun fromStableKey()`, `fun decodeLibraryTabOrder()` |
| [RecentlyPlayedSongUi.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/model/RecentlyPlayedSongUi.kt) | 129 | `class RecentlyPlayedSongUiModel`, `fun mapRecentlyPlayedSongs()`, `fun collectRecentlyPlayedSongIds()`, `fun StatsTimeRange()` |
| [SettingsCategory.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/model/SettingsCategory.kt) | 80 | `enum class SettingsCategory`, `fun fromId()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navidrome/auth` (2 files, 679 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeLoginActivity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navidrome/auth/NavidromeLoginActivity.kt) | 570 | `class NavidromeLoginActivity`, `fun NavidromeLoginScreen()`, `fun ExpressiveLoginField()`, `fun Surface()` |
| [NavidromeLoginViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navidrome/auth/NavidromeLoginViewModel.kt) | 109 | `interface NavidromeLoginState`, `object Idle`, `object Loading`, `class SelectLibraries`, `class Success`, `class Error` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navidrome/dashboard` (2 files, 1,212 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeDashboardScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navidrome/dashboard/NavidromeDashboardScreen.kt) | 1034 | `fun NavidromeDashboardScreen()`, `fun DashboardContent()`, `fun SubsonicMenuCard()`, `fun NavidromeLibrarySummaryPanel()` |
| [NavidromeDashboardViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navidrome/dashboard/NavidromeDashboardViewModel.kt) | 178 | `class NavidromeDashboardViewModel`, `fun observeSyncWorker()`, `fun syncAllPlaylistsAndSongs()`, `fun loadMusicFolders()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navigation` (5 files, 926 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AppNavigation.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navigation/AppNavigation.kt) | 707 | `fun AppNavigation()`, `fun String()`, `enum class MainRootDirection`, `fun mainRootDirection()` |
| [MainRootRoutes.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navigation/MainRootRoutes.kt) | 15 | `fun isMainRootRoute()`, `fun mainRootRouteIndex()` |
| [NavControllerExtensions.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navigation/NavControllerExtensions.kt) | 59 | `fun NavController()`, `fun NavController()`, `fun NavController()`, `fun NavController()` |
| [Screen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navigation/Screen.kt) | 87 | `class Screen`, `object Home`, `object Search`, `object Library`, `object Settings`, `object Accounts` |
| [Transitions.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/navigation/Transitions.kt) | 58 | `fun enterTransition()`, `fun exitTransition()`, `fun popEnterTransition()`, `fun popExitTransition()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens` (39 files, 36,869 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AboutScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/AboutScreen.kt) | 1000 | `class Contributor`, `class ProjectLink`, `fun AboutScreen()`, `fun AboutHeroCard()` |
| [AccountsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/AccountsScreen.kt) | 1118 | `fun AccountsScreen()`, `fun StatTile()`, `fun ConnectedAccountCard()`, `fun EmptyAccountsCard()`, `class ServicePalette` |
| [AlbumDetailScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/AlbumDetailScreen.kt) | 867 | `fun AlbumDetailScreen()`, `fun SharedAlbumTopBarProbe()`, `fun CollapsingAlbumTopBar()` |
| [ArtistDetailScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/ArtistDetailScreen.kt) | 1191 | `fun ArtistDetailScreen()`, `fun ArtistAlbumSection()`, `fun CollapsibleAlbumSectionHeader()`, `fun ArtistAlbumSectionSongItem()` |
| [ArtistSettingsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/ArtistSettingsScreen.kt) | 525 | `fun ArtistSettingsScreen()`, `fun RescanRequiredBanner()`, `fun InfoCard()`, `fun ExamplesCard()` |
| [AudioBookmarkModels.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/AudioBookmarkModels.kt) | 290 | `class AudioBookmarkFolder`, `class BookmarkFolderCardPresentation`, `class BookmarkVisibleItemGeometry`, `fun bookmarkFolderCardPresentation()` |
| [AudioBookmarksScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/AudioBookmarksScreen.kt) | 2070 | `fun AudioBookmarksScreen()`, `fun AudioBookmarkFolderScreen()`, `fun BookmarkFolderTopBar()`, `fun BookmarkFolderSectionHeader()`, `enum class BookmarkFolderSortMode`, `class BookmarkTitleTreatment` |
| [CloudDownloadsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/CloudDownloadsScreen.kt) | 393 | `fun CloudDownloadsScreen()`, `fun StorageSummaryCard()`, `fun SectionHeader()`, `fun DownloadItemCard()`, `class DownloadVisual` |
| [CreatePlaylistScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/CreatePlaylistScreen.kt) | 1664 | `class Quadruple`, `fun smartPlaylistRuleTitle()`, `fun smartPlaylistRuleSubtitle()`, `enum class PlaylistCreationMode` |
| [DailyMixScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/DailyMixScreen.kt) | 540 | `fun DailyMixScreen()`, `fun ExpressiveDailyMixHeader()`, `fun rememberDailyMixTitleStyle()` |
| [DelimiterConfigScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/DelimiterConfigScreen.kt) | 474 | `fun DelimiterConfigScreen()`, `fun DelimiterChip()` |
| [DeviceCapabilitiesScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/DeviceCapabilitiesScreen.kt) | 1502 | `fun DeviceCapabilitiesScreen()`, `fun DeviceCapabilitiesContent()`, `fun PerformanceReportCard()`, `fun AdvancedDiagnosticsToggleRow()`, `enum class FindingTone` |
| [DuplicateSongsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/DuplicateSongsScreen.kt) | 151 | `fun DuplicateSongsScreen()`, `fun DuplicateGroupCard()` |
| [EasterEggScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/EasterEggScreen.kt) | 65 | `fun EasterEggScreen()` |
| [EditTransitionScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/EditTransitionScreen.kt) | 716 | `fun EditTransitionScreen()`, `fun TransitionSummaryCard()`, `fun TransitionModeSection()`, `fun ExpressiveMorphingToggle()` |
| [EqualizerScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/EqualizerScreen.kt) | 1793 | `fun EqualizerScreen()`, `fun PresetTabsRow()`, `fun BandSlidersSection()`, `fun GraphBandSliders()` |
| [ExperimentalSettingsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/ExperimentalSettingsScreen.kt) | 865 | `fun ExperimentalSettingsScreen()`, `fun albumArtQualityLine()`, `fun TriggerModeOptionCard()` |
| [GenreDetailScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/GenreDetailScreen.kt) | 881 | `fun GenreDetailScreen()`, `fun genreFastScrollLabel()`, `fun GenreDetailListItem()`, `fun GenreCollapsibleTopBar()` |
| [HomeScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/HomeScreen.kt) | 827 | `fun HomeScreen()`, `fun YourMixLoadingPlaceholder()`, `fun YourMixEmptyPlaceholder()`, `fun YourMixHeader()` |
| [LibraryEmptyState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/LibraryEmptyState.kt) | 190 | `class LibraryEmptySpec`, `fun libraryEmptySpec()`, `fun LibraryExpressiveEmptyState()` |
| [LibraryMediaTabs.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/LibraryMediaTabs.kt) | 704 | `fun LibraryAlbumsTab()`, `fun LibraryArtistsTab()`, `fun LibraryPlaylistsTab()` |
| [LibraryPlaybackAwareSongItem.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/LibraryPlaybackAwareSongItem.kt) | 64 | `class LibrarySongPlaybackUiState`, `fun LibraryPlaybackAwareSongItem()` |
| [LibraryScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/LibraryScreen.kt) | 3334 | `class LibraryScreenPlayerProjection`, `fun PlayerUiState()`, `fun LibraryScreen()`, `fun CompactLibraryPagerIndicator()` |
| [LibrarySongsAndFavoritesTabs.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/LibrarySongsAndFavoritesTabs.kt) | 511 | `fun LibraryFavoritesTab()`, `fun LibrarySongsTabPaginated()` |
| [LibrarySongsTab.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/LibrarySongsTab.kt) | 369 | `fun LibrarySongsTab()` |
| [MashupScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/MashupScreen.kt) | 339 | `fun MashupScreen()`, `fun DeckUi()`, `fun SliderControl()`, `fun Crossfader()` |
| [NavBarCornerRadiusScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/NavBarCornerRadiusScreen.kt) | 353 | `fun NavBarCornerRadiusScreen()`, `fun NavBarCornerRadiusContent()`, `fun Float()` |
| [PaletteStyleSettingsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/PaletteStyleSettingsScreen.kt) | 750 | `fun PaletteStyleSettingsScreen()`, `fun PaletteStyleHeader()`, `fun MiniFullPlayerSkeletonPreview()`, `fun scaled()` |
| [PlaylistDetailScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/PlaylistDetailScreen.kt) | 1196 | `fun PlaylistDetailScreen()`, `fun PlaylistActionItem()`, `fun RenamePlaylistDialog()` |
| [QuickFillScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/QuickFillScreen.kt) | 461 | `fun QuickFillDialog()`, `fun QuickFillContent()`, `fun GenreValidatorContent()` |
| [RecentlyPlayedScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/RecentlyPlayedScreen.kt) | 768 | `fun RecentlyPlayedScreen()`, `fun ExpressiveRecentlyPlayedHeader()`, `fun rememberRecentlyPlayedTitleStyle()`, `fun RecentlyPlayedActions()`, `class TimestampGroup`, `class TimestampBucket` |
| [SearchScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/SearchScreen.kt) | 1168 | `class SearchUiSlice`, `fun SearchScreen()`, `fun SearchResultSectionHeader()`, `fun SearchHistoryList()` |
| [SettingsCategoryScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/SettingsCategoryScreen.kt) | 2718 | `fun SettingsCategoryScreen()`, `fun buildBackupSelectionSummary()`, `fun backupSectionIconRes()`, `fun BackupInfoNoticeCard()` |
| [SettingsComponents.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/SettingsComponents.kt) | 718 | `fun SettingsSection()`, `fun SettingsItem()`, `fun SwitchSettingItem()`, `fun ThemeSelectorItem()` |
| [SettingsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/SettingsScreen.kt) | 664 | `fun SettingsScreen()`, `fun shapeFor()`, `fun ExpressiveNavigationItem()`, `fun ExpressiveCategoryItem()` |
| [SetupScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/SetupScreen.kt) | 2468 | `fun SetupScreen()`, `fun DirectorySelectionPage()`, `class SetupPage`, `object Welcome`, `object MediaPermission`, `object BackupRestore` |
| [StatsScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/StatsScreen.kt) | 2607 | `fun StatsScreen()`, `fun StatsHeroSection()`, `fun HeroCard()`, `fun StatsEmptyState()`, `enum class TimelineMetric`, `enum class CategoryDimension` |
| [TabAnimation.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/TabAnimation.kt) | 121 | `fun TabAnimation()` |
| [WordDelimiterConfigScreen.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/WordDelimiterConfigScreen.kt) | 434 | `fun WordDelimiterConfigScreen()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/search/components` (3 files, 944 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [GenreCategoriesGrid.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/search/components/GenreCategoriesGrid.kt) | 265 | `fun GenreCategoriesGrid()`, `fun GenreCard()` |
| [GenreTypography.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/search/components/GenreTypography.kt) | 415 | `object GenreTypography`, `class TitlePresentation`, `fun resolveTitlePresentation()`, `fun getGenreStyle()`, `class BreakCandidate`, `class GenreTitleProfile` |
| [GenreiconProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/screens/search/components/GenreiconProvider.kt) | 264 | `fun getGenreImageResource()`, `fun splitGenreParts()`, `fun keywordFallback()`, `fun normalizeGenreKey()`, `object GenreMapBuilder` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/settings/search` (5 files, 1,237 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SettingHighlightModifier.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/settings/search/SettingHighlightModifier.kt) | 59 | `fun Modifier()` |
| [SettingSpec.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/settings/search/SettingSpec.kt) | 58 | `enum class SettingType`, `class SettingSpec`, `fun getTitle()`, `fun getSubtitle()`, `class SearchResultItem`, `class SearchResultSection` |
| [SettingsFuzzySearchEngine.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/settings/search/SettingsFuzzySearchEngine.kt) | 199 | `object SettingsFuzzySearchEngine`, `fun search()`, `fun calculateScore()`, `fun normalize()` |
| [SettingsRegistry.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/settings/search/SettingsRegistry.kt) | 600 | `object SettingsRegistry` |
| [SettingsSearchComponents.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/settings/search/SettingsSearchComponents.kt) | 321 | `fun SettingsSearchResultsContent()`, `fun SearchResultSwitchItem()`, `fun SearchResultNavigableItem()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/stats` (1 files, 14 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [StatsTimeRangeUi.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/stats/StatsTimeRangeUi.kt) | 14 | `fun StatsTimeRange()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/utils` (2 files, 664 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AppHaptics.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/utils/AppHaptics.kt) | 39 | `class AppHapticsConfig`, `fun View()`, `fun performAppCompatHapticFeedback()` |
| [GenreIconProvider.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/utils/GenreIconProvider.kt) | 625 | `object GenreIconProvider`, `fun getGenreImageResource()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel` (46 files, 17,226 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AccountsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/AccountsViewModel.kt) | 309 | `enum class ExternalServiceAccount`, `class ExternalAccountUiModel`, `class ListenBrainzUiModel`, `interface ListenBrainzStatsUiState`, `object Loading`, `object Unavailable` |
| [AlbumDetailViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/AlbumDetailViewModel.kt) | 136 | `class AlbumDetailUiState`, `class AlbumDetailViewModel`, `fun loadAlbumData()`, `fun retry()` |
| [ArtistDetailViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/ArtistDetailViewModel.kt) | 300 | `class ArtistDetailUiState`, `class ArtistAlbumSection`, `class ArtistDetailViewModel`, `fun loadArtistData()` |
| [ArtistSettingsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/ArtistSettingsViewModel.kt) | 157 | `class ArtistSettingsUiState`, `class ArtistSettingsViewModel`, `fun setGroupByAlbumArtist()`, `fun setArtistDelimiters()` |
| [AudioBookmarksViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/AudioBookmarksViewModel.kt) | 63 | `class AudioBookmarksViewModel`, `fun observeSongs()`, `fun addBookmark()`, `fun deleteBookmark()` |
| [CloudDownloadsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/CloudDownloadsViewModel.kt) | 75 | `class CloudDownloadsUiState`, `fun List()`, `class CloudDownloadsViewModel`, `fun remove()` |
| [ColorSchemePair.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/ColorSchemePair.kt) | 8 | `class ColorSchemePair` |
| [ColorSchemeProcessor.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/ColorSchemeProcessor.kt) | 432 | `class ColorSchemeProcessor`, `fun clearMemoryCache()`, `fun evictFromCache()`, `fun removeUriFromMemoryCache()` |
| [ConnectivityStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/ConnectivityStateHolder.kt) | 531 | `class BluetoothAudioDeviceState`, `class ConnectivityStateHolder`, `fun initialize()`, `fun checkConnectivity()` |
| [DailyMixStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/DailyMixStateHolder.kt) | 156 | `class DailyMixStateHolder`, `fun initialize()`, `fun removeFromDailyMix()`, `fun updateDailyMix()` |
| [DeviceCapabilitiesViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/DeviceCapabilitiesViewModel.kt) | 642 | `class CodecInfo`, `class AudioOutputInfo`, `enum class AudioOutputCategory`, `class AudioCapabilities`, `class FormatSupportInfo`, `class LocalMusicStorageSummary` |
| [DuplicateSongsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/DuplicateSongsViewModel.kt) | 45 | `class DuplicateSongsUiState`, `class DuplicateSongsViewModel`, `fun scan()` |
| [EqualizerViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/EqualizerViewModel.kt) | 509 | `class EqualizerUiState`, `class EqualizerViewModel`, `fun loadSystemVolume()`, `fun setSystemVolume()` |
| [ExternalMediaStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/ExternalMediaStateHolder.kt) | 361 | `class ExternalSongLoadResult`, `class ExternalMediaStateHolder`, `fun Uri()`, `fun resolveDirectFilePath()` |
| [FileExplorerStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/FileExplorerStateHolder.kt) | 560 | `class DirectoryEntry`, `class RawDirectoryEntry`, `fun mergeDirectoryEntryLists()`, `class MediaStoreDirectoryIndex`, `class FileExplorerStateHolder` |
| [FolderNavigationStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/FolderNavigationStateHolder.kt) | 128 | `class FolderNavigationStateHolder`, `fun setFoldersPlaylistViewState()`, `fun navigateToFolder()`, `fun navigateBackFolder()` |
| [GenreDetailViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/GenreDetailViewModel.kt) | 321 | `enum class SortOption`, `class AlbumData`, `class SectionData`, `class ArtistSection`, `class AlbumSection`, `class FlatList` |
| [LibraryStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/LibraryStateHolder.kt) | 577 | `class GenreSeed`, `class LibraryStateHolder`, `fun effectiveFoldersStorageFilter()`, `fun initialize()` |
| [LibraryTabsStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/LibraryTabsStateHolder.kt) | 62 | `class LibraryTabsStateHolder`, `fun showSortingSheet()`, `fun hideSortingSheet()`, `fun onLibraryTabSelected()` |
| [LibraryViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/LibraryViewModel.kt) | 25 | `class LibraryViewModel` |
| [ListeningStatsTracker.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/ListeningStatsTracker.kt) | 353 | `class ListeningStatsTracker`, `fun initialize()`, `fun onVoluntarySelection()`, `fun onSongChanged()`, `class ActiveSession` |
| [LyricsSearchUiState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/LyricsSearchUiState.kt) | 14 | `interface LyricsSearchUiState`, `object Idle`, `object Loading`, `class PickResult`, `class Success`, `class NotFound` |
| [LyricsStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/LyricsStateHolder.kt) | 408 | `interface LyricsLoadCallback`, `fun onLoadingStarted()`, `fun onLyricsLoaded()`, `class LyricsStateHolder` |
| [MainViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/MainViewModel.kt) | 99 | `class MainViewModel`, `fun startSync()`, `fun retrySync()` |
| [MashupViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/MashupViewModel.kt) | 138 | `class DeckState`, `class MashupUiState`, `class MashupViewModel`, `fun initializeDecks()` |
| [MetadataEditStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/MetadataEditStateHolder.kt) | 214 | `class MetadataEditStateHolder`, `class MetadataEditResult`, `fun getUserFriendlyErrorMessage()`, `fun resolveSongIdForMetadataEdit()` |
| [MultiSelectionStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/MultiSelectionStateHolder.kt) | 132 | `class MultiSelectionStateHolder`, `fun toggleSelection()`, `fun selectAll()`, `fun clearSelection()` |
| [PlaybackStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlaybackStateHolder.kt) | 865 | `class PlaybackStateHolder`, `fun setSliderUiMounted()`, `fun clearColdStartSnapshot()`, `fun rememberColdStartSnapshot()`, `class PreparedQueueReplacement`, `class PreparedQueueSegments` |
| [PlayerSheetState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlayerSheetState.kt) | 6 | `enum class PlayerSheetState` |
| [PlayerUiState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlayerUiState.kt) | 59 | `class PlayerUiState` |
| [PlayerViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlayerViewModel.kt) | 4857 | `fun List()`, `fun ImmutableList()`, `fun ImmutableList()`, `fun ImmutableList()`, `class QueueTimelineSignature`, `class PlaybackAudioMetadata` |
| [PlaylistDismissUndoStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlaylistDismissUndoStateHolder.kt) | 164 | `class PlaylistDismissUndoStateHolder`, `fun dismissPlaylistAndShowUndo()`, `fun hideDismissUndoBar()`, `fun observeUndoStateAgainstPlayback()` |
| [PlaylistSelectionStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlaylistSelectionStateHolder.kt) | 128 | `class PlaylistSelectionStateHolder`, `fun toggleSelection()`, `fun selectAll()`, `fun clearSelection()` |
| [PlaylistViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlaylistViewModel.kt) | 1112 | `class PlaylistUiState`, `class PlaylistSongsOrderMode`, `object Manual`, `class Sorted`, `class NlpPlaylistPreviewState`, `class PlaylistViewModel` |
| [QueueStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/QueueStateHolder.kt) | 56 | `class QueueStateHolder`, `fun setOriginalQueueOrder()`, `fun hasOriginalQueue()` |
| [QueueUndoStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/QueueUndoStateHolder.kt) | 99 | `class QueueUndoStateHolder`, `fun removeSongFromQueue()`, `fun undoRemoveSongFromQueue()`, `fun hideQueueItemUndoBar()` |
| [SearchStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/SearchStateHolder.kt) | 202 | `class SearchStateHolder`, `class SearchRequest`, `fun initialize()`, `fun observeSearchRequests()` |
| [SettingsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/SettingsViewModel.kt) | 1059 | `class SettingsUiState`, `class FailedSongInfo`, `class LyricsRefreshProgress`, `interface SettingsUiUpdate`, `class Group1`, `class Group2` |
| [SetupViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/SetupViewModel.kt) | 425 | `class SetupUiState`, `interface SetupEvent`, `class Message`, `class RestoreCompleted`, `class SetupViewModel`, `class SetupPrefsUpdate` |
| [SleepTimerStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/SleepTimerStateHolder.kt) | 297 | `class SleepTimerStateHolder`, `fun sleepTimerPendingIntent()`, `fun initialize()`, `fun setSleepTimer()` |
| [SongInfoBottomSheetViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/SongInfoBottomSheetViewModel.kt) | 390 | `class SongInfoBottomSheetViewModel`, `class SongLocationInfo`, `enum class ToneTarget`, `interface ToneActionResult`, `class Success`, `class NeedsSystemWritePermission` |
| [SongRemovalStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/SongRemovalStateHolder.kt) | 68 | `class SongRemovalStateHolder` |
| [StablePlayerState.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/StablePlayerState.kt) | 21 | `class StablePlayerState` |
| [StatsViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/StatsViewModel.kt) | 197 | `class StatsViewModel`, `class StatsUiState`, `fun onRangeSelected()`, `fun refreshWeeklyOverview()` |
| [ThemeStateHolder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/ThemeStateHolder.kt) | 312 | `class ThemeStateHolder`, `fun initialize()`, `fun updateLavaLampColors()`, `fun requestAlbumColorSchemeGeneration()` |
| [TransitionViewModel.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/TransitionViewModel.kt) | 154 | `class TransitionUiState`, `class TransitionViewModel`, `fun loadSettings()`, `fun getCurrentSettings()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/exts` (1 files, 149 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DeckController.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/exts/DeckController.kt) | 149 | `class DeckController`, `fun loadSong()`, `fun buildSafePlayer()`, `fun playPause()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget` (14 files, 2,528 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BarWidget4x1.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/BarWidget4x1.kt) | 147 | `class BarWidget4x1`, `fun BarWidget4x1Content()` |
| [BarWidget4x1Receiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/BarWidget4x1Receiver.kt) | 8 | `class BarWidget4x1Receiver` |
| [ControlWidget4x2.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/ControlWidget4x2.kt) | 195 | `class ControlWidget4x2`, `fun ControlWidget4x2Content()` |
| [ControlWidget4x2Receiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/ControlWidget4x2Receiver.kt) | 8 | `class ControlWidget4x2Receiver` |
| [GridWidget2x2.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/GridWidget2x2.kt) | 147 | `class GridWidget2x2`, `fun GridWidget2x2Content()` |
| [GridWidget2x2Receiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/GridWidget2x2Receiver.kt) | 8 | `class GridWidget2x2Receiver` |
| [PixelPlayerGlanceWidget.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/PixelPlayerGlanceWidget.kt) | 1366 | `class PixelPlayerGlanceWidget`, `fun WidgetUi()`, `fun VeryThinWidgetLayout()`, `fun ThinWidgetLayout()` |
| [PixelPlayerGlanceWidgetReceiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/PixelPlayerGlanceWidgetReceiver.kt) | 8 | `class PixelPlayerGlanceWidgetReceiver` |
| [PlayerControlActionCallback.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/PlayerControlActionCallback.kt) | 83 | `class PlayerControlActionCallback`, `object PlayerActions` |
| [PlayerInfoStateDefinition.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/PlayerInfoStateDefinition.kt) | 61 | `object PlayerInfoStateDefinition`, `class PlayerInfoJsonSerializer` |
| [WidgetArtworkDecoder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/WidgetArtworkDecoder.kt) | 80 | `fun decodeWidgetAlbumArtBitmap()`, `fun readBytesCapped()` |
| [WidgetComponents.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/WidgetComponents.kt) | 276 | `fun AlbumArtImage()`, `fun decodeAlbumArtFromUri()`, `fun WidgetIconButton()`, `fun PreviousButton()` |
| [WidgetUpdateReceiver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/WidgetUpdateReceiver.kt) | 52 | `class WidgetUpdateReceiver` |
| [WidgetUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/glancewidget/WidgetUtils.kt) | 89 | `object AlbumArtBitmapCache`, `fun getBitmap()`, `fun putBitmap()`, `fun getKey()`, `class WidgetColors` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/ui/theme` (7 files, 1,478 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [Color.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/theme/Color.kt) | 22 | - |
| [ColorRoles.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/theme/ColorRoles.kt) | 730 | `class ColorScoringConfig`, `class ColorExtractionConfig`, `class ScoredHct`, `class RepresentativeArtworkColor` |
| [GenreColors.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/theme/GenreColors.kt) | 242 | `class GenreThemeColor`, `object GenreThemeUtils`, `fun isUnknownGenreId()`, `fun getGenreThemeColor()` |
| [Shape.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/theme/Shape.kt) | 11 | - |
| [ShapeCache.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/theme/ShapeCache.kt) | 90 | `object ShapeCache`, `class RoundedPolygonShape` |
| [Theme.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/theme/Theme.kt) | 147 | `fun PixelPlayerStatusBarStyle()`, `fun PixelPlayerTheme()` |
| [Type.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/ui/theme/Type.kt) | 236 | - |

## `app/src/main/java/com/lostf1sh/pixelplayeross/utils` (29 files, 5,515 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtCacheManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/AlbumArtCacheManager.kt) | 291 | `object AlbumArtCacheManager`, `class CacheEvictionCandidate`, `fun getCachedFileCount()`, `fun getAlbumArtFiles()` |
| [AlbumArtUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/AlbumArtUtils.kt) | 581 | `object AlbumArtUtils`, `fun getAlbumArtUri()`, `fun getAlbumArtUriForLibraryScan()`, `fun getCachedAlbumArtUri()`, `class MediaStoreSongInfo` |
| [AppLocaleManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/AppLocaleManager.kt) | 57 | `object AppLocaleManager`, `fun currentLanguageTag()`, `fun applyLanguage()`, `fun wrapContext()` |
| [AppShortcutManager.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/AppShortcutManager.kt) | 76 | `class AppShortcutManager`, `fun updateLastPlaylistShortcut()`, `fun removeLastPlaylistShortcut()` |
| [ArtworkTransportSanitizer.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/ArtworkTransportSanitizer.kt) | 130 | `object ArtworkTransportSanitizer`, `class Config`, `fun sanitizeEncodedBytes()`, `fun decodeBoundedBitmap()` |
| [AudioMetaUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/AudioMetaUtils.kt) | 174 | `class AudioMeta`, `object AudioMetaUtils`, `fun mimeTypeToFormat()` |
| [ColorUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/ColorUtils.kt) | 125 | `fun getContrastColor()`, `fun createScalableBackgroundBitmap()` |
| [CrashHandler.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/CrashHandler.kt) | 131 | `class CrashLogData`, `fun getFullLog()`, `object CrashHandler`, `fun install()` |
| [DirectoryFilterUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/DirectoryFilterUtils.kt) | 25 | `object DirectoryFilterUtils` |
| [DirectoryRuleResolver.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/DirectoryRuleResolver.kt) | 55 | `class DirectoryRuleResolver`, `fun isBlocked()`, `fun normalize()`, `fun isParentOrSame()` |
| [Envelope.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/Envelope.kt) | 27 | `fun envelope()` |
| [Extensions.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/Extensions.kt) | 177 | `fun Color()`, `fun String()`, `fun String()`, `fun String()` |
| [FileDeletionUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/FileDeletionUtils.kt) | 163 | `object FileDeletionUtils`, `fun getDeleteRequestIntentSender()`, `class FileInfo` |
| [Formats.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/Formats.kt) | 77 | `fun formatDuration()`, `fun formatTotalDuration()`, `fun formatListeningDurationLong()`, `fun formatListeningDurationCompact()` |
| [LocalArtworkUri.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/LocalArtworkUri.kt) | 119 | `object LocalArtworkUri`, `fun buildSongUri()`, `fun buildSongUriWithTimestamp()`, `fun isLocalArtworkUri()` |
| [LogUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/LogUtils.kt) | 33 | `object LogUtils`, `fun getTag()`, `fun buildLogMessage()`, `fun d()` |
| [LyricsImportSecurity.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/LyricsImportSecurity.kt) | 291 | `class ValidatedLyricsImport`, `enum class LyricsImportFailureReason`, `interface LyricsImportValidationResult`, `class Valid`, `class Invalid`, `object LyricsImportSecurity` |
| [LyricsUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/LyricsUtils.kt) | 1320 | `object MultiLangRomanizer`, `fun isJapanese()`, `fun isKorean()`, `fun isHindi()`, `object LyricsUtils` |
| [MediaItemBuilder.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/MediaItemBuilder.kt) | 368 | `object MediaItemBuilder`, `fun build()`, `fun buildForExternalController()`, `fun playbackUri()` |
| [MediaMetadataRetrieverPool.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/MediaMetadataRetrieverPool.kt) | 82 | `object MediaMetadataRetrieverPool`, `fun acquire()`, `fun release()`, `fun clear()` |
| [MediaStorePermissionHelper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/MediaStorePermissionHelper.kt) | 321 | `object MediaStorePermissionHelper`, `class DeleteRequest`, `fun getMediaStoreUri()`, `fun getMediaStoreUri()` |
| [MediaStoreSelectionUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/MediaStoreSelectionUtils.kt) | 44 | `fun buildLocalAudioSelection()` |
| [NetworkRetryUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/NetworkRetryUtils.kt) | 43 | `object NetworkRetryUtils`, `fun Throwable()` |
| [PlaylistCoverColors.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/PlaylistCoverColors.kt) | 28 | `fun resolvePlaylistCoverContentColor()` |
| [QueueUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/QueueUtils.kt) | 191 | `object QueueUtils`, `fun generateShuffleOrder()`, `fun buildAnchoredShuffleQueue()` |
| [StorageUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/StorageUtils.kt) | 136 | `enum class StorageType`, `class StorageInfo`, `object StorageUtils`, `fun getAvailableStorages()` |
| [TraceUtils.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/TraceUtils.kt) | 38 | - |
| [TtmlLyricsParser.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/TtmlLyricsParser.kt) | 205 | `object TtmlLyricsParser`, `fun parseToEnhancedLrc()`, `fun normalizeTtmlDocument()`, `fun resolveParagraphStartMs()` |
| [ZipShareHelper.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/ZipShareHelper.kt) | 207 | `object ZipShareHelper`, `fun isLargeZip()`, `fun formatFileSize()`, `fun cleanupTempZips()` |

## `app/src/main/java/com/lostf1sh/pixelplayeross/utils/shapes` (1 files, 72 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [RoundedStarShape.kt](file:///home/dharshan/PixelPlayerOSS/app/src/main/java/com/lostf1sh/pixelplayeross/utils/shapes/RoundedStarShape.kt) | 72 | `class RoundedStarShape`, `fun pointAt()`, `fun mapRange()` |

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

## `app/src/main/res/font` (2 files, 90,612 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [genre_variable.ttf](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/font/genre_variable.ttf) | 27273 | - |
| [gflex_variable.ttf](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/font/gflex_variable.ttf) | 63339 | - |

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

## `app/src/main/res/mipmap-hdpi` (4 files, 105 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-hdpi/ic_launcher.webp) | 39 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-hdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-hdpi/ic_launcher_foreground.webp) | 26 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-hdpi/ic_launcher_round.webp) | 39 | - |

## `app/src/main/res/mipmap-mdpi` (4 files, 73 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-mdpi/ic_launcher.webp) | 28 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-mdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-mdpi/ic_launcher_foreground.webp) | 16 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-mdpi/ic_launcher_round.webp) | 28 | - |

## `app/src/main/res/mipmap-xhdpi` (4 files, 124 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xhdpi/ic_launcher.webp) | 41 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xhdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xhdpi/ic_launcher_foreground.webp) | 41 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xhdpi/ic_launcher_round.webp) | 41 | - |

## `app/src/main/res/mipmap-xxhdpi` (4 files, 234 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxhdpi/ic_launcher.webp) | 68 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxhdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxhdpi/ic_launcher_foreground.webp) | 97 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxhdpi/ic_launcher_round.webp) | 68 | - |

## `app/src/main/res/mipmap-xxxhdpi` (4 files, 312 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ic_launcher.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp) | 102 | - |
| [ic_launcher_background.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxxhdpi/ic_launcher_background.webp) | 1 | - |
| [ic_launcher_foreground.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxxhdpi/ic_launcher_foreground.webp) | 107 | - |
| [ic_launcher_round.webp](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.webp) | 102 | - |

## `app/src/main/res/values` (15 files, 2,074 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [colors.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/colors.xml) | 8 | - |
| [plurals.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/plurals.xml) | 39 | - |
| [strings.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/values/strings.xml) | 275 | - |
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
| [pixelplayer_glance_widget_info.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/pixelplayer_glance_widget_info.xml) | 14 | - |
| [shortcuts.xml](file:///home/dharshan/PixelPlayerOSS/app/src/main/res/xml/shortcuts.xml) | 15 | - |

## `app/src/release/generated/baselineProfiles` (2 files, 80,806 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [baseline-prof.txt](file:///home/dharshan/PixelPlayerOSS/app/src/release/generated/baselineProfiles/baseline-prof.txt) | 43587 | - |
| [startup-prof.txt](file:///home/dharshan/PixelPlayerOSS/app/src/release/generated/baselineProfiles/startup-prof.txt) | 37219 | - |

## `app/src/test/java/com/lostf1sh/pixelplayeross` (2 files, 41 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExampleUnitTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/ExampleUnitTest.kt) | 17 | `class ExampleUnitTest`, `fun addition_isCorrect()` |
| [MainCoroutineExtension.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/MainCoroutineExtension.kt) | 24 | `class MainCoroutineExtension` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/backup` (1 files, 170 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupManagerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/BackupManagerTest.kt) | 170 | `class BackupManagerTest`, `fun restorePlan()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/format` (2 files, 180 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupFormatDetectorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/format/BackupFormatDetectorTest.kt) | 56 | `class BackupFormatDetectorTest` |
| [LegacyPayloadAdapterTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/format/LegacyPayloadAdapterTest.kt) | 124 | `class LegacyPayloadAdapterTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/model` (1 files, 85 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [BackupSectionTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/model/BackupSectionTest.kt) | 85 | `class BackupSectionTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/module` (2 files, 163 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [EngagementStatsModuleHandlerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/module/EngagementStatsModuleHandlerTest.kt) | 99 | `class EngagementStatsModuleHandlerTest` |
| [FavoritesModuleHandlerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/module/FavoritesModuleHandlerTest.kt) | 64 | `class FavoritesModuleHandlerTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/restore` (1 files, 140 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [RestoreExecutorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/restore/RestoreExecutorTest.kt) | 140 | `class RestoreExecutorTest`, `fun restorePlan()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/validation` (3 files, 359 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ContentSanitizerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/validation/ContentSanitizerTest.kt) | 81 | `class ContentSanitizerTest` |
| [ManifestValidatorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/validation/ManifestValidatorTest.kt) | 131 | `class ManifestValidatorTest`, `fun sha256()` |
| [ModuleSchemaValidatorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/backup/validation/ModuleSchemaValidatorTest.kt) | 147 | `class ModuleSchemaValidatorTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/database` (2 files, 52 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MusicDaoTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/database/MusicDaoTest.kt) | 14 | - |
| [NavidromeSongEntityTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/database/NavidromeSongEntityTest.kt) | 38 | `class NavidromeSongEntityTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/equalizer` (1 files, 79 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExternalAudioEffectSessionTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/equalizer/ExternalAudioEffectSessionTest.kt) | 79 | `class ExternalAudioEffectSessionTest`, `fun setUp()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/jellyfin` (1 files, 99 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/jellyfin/JellyfinRepositoryTest.kt) | 99 | `class JellyfinRepositoryTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/jellyfin/model` (1 files, 101 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinCredentialsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/jellyfin/model/JellyfinCredentialsTest.kt) | 101 | `class JellyfinCredentialsTest`, `fun creds()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/library` (1 files, 70 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DuplicateFinderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/library/DuplicateFinderTest.kt) | 70 | `class DuplicateFinderTest`, `fun song()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/listenbrainz` (3 files, 172 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ListenBrainzEndpointTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/listenbrainz/ListenBrainzEndpointTest.kt) | 69 | `class ListenBrainzEndpointTest`, `fun parseBaseUrl_defaultsSchemeToHttpsAndAppendsSlash()`, `fun parseBaseUrl_keepsPathPrefixAndExplicitScheme()`, `fun parseBaseUrl_rejectsNonHttpSchemesAndGarbage()` |
| [ListenBrainzProfileStatsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/listenbrainz/ListenBrainzProfileStatsTest.kt) | 63 | `class ListenBrainzProfileStatsTest`, `fun nullWhenServerExposesNeitherEndpoint()`, `fun carriesListenCountWithoutPlayingNowSupport()`, `fun supportedButIdlePlayingNowKeepsNullTrack()` |
| [ScrobbleManagerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/listenbrainz/ScrobbleManagerTest.kt) | 40 | `class ScrobbleManagerTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/model` (2 files, 102 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SmartPlaylistRuleTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/model/SmartPlaylistRuleTest.kt) | 47 | `class SmartPlaylistRuleTest` |
| [SortOptionTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/model/SortOptionTest.kt) | 55 | `class SortOptionTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/musicbrainz` (1 files, 84 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [MusicBrainzApiServiceTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/musicbrainz/MusicBrainzApiServiceTest.kt) | 84 | `class MusicBrainzApiServiceTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/navidrome` (1 files, 104 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/navidrome/NavidromeRepositoryTest.kt) | 104 | `class NavidromeRepositoryTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/navidrome/model` (1 files, 79 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeCredentialsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/navidrome/model/NavidromeCredentialsTest.kt) | 79 | `class NavidromeCredentialsTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/network/navidrome` (1 files, 80 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [NavidromeApiServiceAuthTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/network/navidrome/NavidromeApiServiceAuthTest.kt) | 80 | `class NavidromeApiServiceAuthTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/offline` (1 files, 48 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudOfflineRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/offline/CloudOfflineRepositoryTest.kt) | 48 | `class CloudOfflineRepositoryTest`, `fun song()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist` (1 files, 136 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SmartPlaylistBuilderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/SmartPlaylistBuilderTest.kt) | 136 | `class SmartPlaylistBuilderTest`, `fun daysAgo()`, `fun song()`, `fun stats()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/nlp` (8 files, 796 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [GenreTaxonomyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/GenreTaxonomyTest.kt) | 68 | `class GenreTaxonomyTest`, `fun fam()`, `fun qfam()` |
| [LocalMetadataHeuristicsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/LocalMetadataHeuristicsTest.kt) | 56 | `class LocalMetadataHeuristicsTest` |
| [MultiMoodTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/MultiMoodTest.kt) | 98 | `class MultiMoodTest`, `fun song()` |
| [NegationTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/NegationTest.kt) | 63 | `class NegationTest`, `fun song()` |
| [NlpTextTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/NlpTextTest.kt) | 47 | `class NlpTextTest` |
| [PlaylistIntentEngineTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/PlaylistIntentEngineTest.kt) | 288 | `class PlaylistIntentEngineTest`, `fun song()`, `fun generate()` |
| [SimilarityIntentTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/SimilarityIntentTest.kt) | 80 | `class SimilarityIntentTest`, `fun song()`, `fun generate()` |
| [VibeVectorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/playlist/nlp/VibeVectorTest.kt) | 96 | `class VibeVectorTest`, `fun song()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/preferences` (1 files, 131 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [UserPreferencesRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/preferences/UserPreferencesRepositoryTest.kt) | 131 | `class UserPreferencesRepositoryTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/provider` (1 files, 93 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SharedArtworkContentProviderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/provider/SharedArtworkContentProviderTest.kt) | 93 | `class SharedArtworkContentProviderTest`, `fun buildSongUri_usesDedicatedArtworkAuthority()`, `fun buildSongUri_preservesCacheBustToken()`, `fun parseSongId_rejectsOtherAuthorities()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/repository` (4 files, 889 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ArtistImageRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/repository/ArtistImageRepositoryTest.kt) | 106 | `class ArtistImageRepositoryTest`, `fun userPreferencesRepository()` |
| [FolderTreeBuilderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/repository/FolderTreeBuilderTest.kt) | 96 | `class FolderTreeBuilderTest`, `fun inferRemovableStorageRoots_usesSdCardVolumeRoot()`, `fun buildFolderTreeForRoots_includesSdCardFolders()`, `fun buildFolderTreeForRoots_doesNotMatchSiblingPathPrefix()` |
| [LyricsRepositoryImplTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/repository/LyricsRepositoryImplTest.kt) | 354 | `class LyricsRepositoryImplTest`, `fun getLyrics_returnsSongLyricsBeforeNeedingStorageRead()`, `fun getLyrics_apiFirst_usesStoredLyricsBeforeCallingLrcLib()`, `fun fetchFromRemote_returnsStoredLyricsWithoutCallingApi()` |
| [MusicRepositoryImplTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/repository/MusicRepositoryImplTest.kt) | 333 | `class MusicRepositoryImplTest`, `fun setUp()`, `fun tearDown()`, `fun createSongEntity()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/service` (3 files, 363 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [PlaybackTimerControllerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/service/PlaybackTimerControllerTest.kt) | 244 | `class PlaybackTimerControllerTest`, `class FakeAlarmScheduler`, `fun mediaItem()`, `fun setUp()` |
| [TaskRemovedPolicyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/service/TaskRemovedPolicyTest.kt) | 47 | `class TaskRemovedPolicyTest`, `fun taskRemoved_continuesPlaybackWhenPlayingAndBackgroundPlaybackEnabled()`, `fun taskRemoved_stopsWhenBackgroundPlaybackDisabled()`, `fun taskRemoved_stopsWhenNothingIsPlaying()` |
| [TrustedMediaItemsResolutionTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/service/TrustedMediaItemsResolutionTest.kt) | 72 | `class TrustedMediaItemsResolutionTest`, `fun mediaItem()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/service/player` (5 files, 521 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AudioDecoderPolicyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/service/player/AudioDecoderPolicyTest.kt) | 51 | `class AudioDecoderPolicyTest`, `fun selectPlatformDecoders_routesAlacToExtensionRenderer()`, `fun selectPlatformDecoders_routesMidiToExtensionRenderer()`, `fun selectPlatformDecoders_preservesMedia3OrderForCoreFormats()` |
| [AudioFocusResumePolicyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/service/player/AudioFocusResumePolicyTest.kt) | 59 | `class AudioFocusResumePolicyTest`, `fun transientFocusLoss_doesNotResumeWhenPlaybackWasAlreadyPaused()`, `fun transientFocusLoss_resumesWhenMasterWasPlaying()`, `fun transientFocusLoss_resumesWhenAuxiliaryTransitionWasPlaying()` |
| [AudioOffloadPolicyTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/service/player/AudioOffloadPolicyTest.kt) | 211 | `class AudioOffloadPolicyTest`, `fun defaultPolicy_disablesOffloadForReportedLavaMtkDeviceOnAndroid15()`, `fun defaultPolicy_keepsOffloadForPixelOnAndroid15()`, `fun defaultPolicy_disablesOffloadForPixelOnSdk37()` |
| [HiResSampleRateCapAudioProcessorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/service/player/HiResSampleRateCapAudioProcessorTest.kt) | 113 | `class HiResSampleRateCapAudioProcessorTest`, `fun configure_keepsSupportedSampleRatesUntouched()`, `fun queueInput_downsamples384KhzStereoTo192Khz()`, `fun queueInput_carriesPartialFramesAcrossCalls()` |
| [SurroundDownmixProcessorTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/service/player/SurroundDownmixProcessorTest.kt) | 87 | `class SurroundDownmixProcessorTest`, `fun queueInput_downmixes51Pcm16BitToStereo()`, `fun queueInput_downmixes71FloatToStereo()`, `fun shortBufferOf()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/stats` (1 files, 258 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [PlaybackStatsRepositoryTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/stats/PlaybackStatsRepositoryTest.kt) | 258 | `class PlaybackStatsRepositoryTest`, `fun createRepository()`, `fun song()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/stream` (2 files, 136 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudStreamSecurityIdTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/stream/CloudStreamSecurityIdTest.kt) | 58 | `class CloudStreamSecurityIdTest` |
| [CloudStreamSecurityTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/stream/CloudStreamSecurityTest.kt) | 78 | `class CloudStreamSecurityTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/data/worker` (3 files, 313 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumGroupingUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/worker/AlbumGroupingUtilsTest.kt) | 155 | `class AlbumGroupingUtilsTest` |
| [ArtistParsingUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/worker/ArtistParsingUtilsTest.kt) | 53 | `class ArtistParsingUtilsTest` |
| [SyncWorkerRequestTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/data/worker/SyncWorkerRequestTest.kt) | 105 | `class SyncWorkerRequestTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/presentation/components` (4 files, 323 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ExpressiveScrollBarMetricsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/components/ExpressiveScrollBarMetricsTest.kt) | 54 | `class ExpressiveScrollBarMetricsTest`, `fun resolveDragTargetIndex_mapsBottomProgressToLastItem()`, `fun extractFastScrollGlyph_skipsPunctuationAndBucketsNumbers()`, `fun distanceBeforeIndex_preservesObservedOutlierStrides()` |
| [LyricsSheetLogicTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/components/LyricsSheetLogicTest.kt) | 202 | `class LyricsSheetLogicTest`, `fun sanitizeSyncedWords_removesLeadingTags_preventsOverlap()`, `fun highlightSnapOffsetPx_alignsLineWithHighlightZone()`, `fun highlightSnapOffsetPx_clampsWithinViewportForEndOfList()` |
| [OptimizedAlbumArtTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/components/OptimizedAlbumArtTest.kt) | 26 | `class OptimizedAlbumArtTest`, `fun safeAlbumArtTargetSize_clampsOriginalRequests()`, `fun safeAlbumArtTargetSize_keepsBoundedRequests()` |
| [PlayerBottomAnchoringTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/components/PlayerBottomAnchoringTest.kt) | 41 | `class PlayerBottomAnchoringTest`, `fun sanitizeNavigationBarBottomInset_clampsImpossibleFloatingWindowInsets()`, `fun calculatePlayerSheetCollapsedTargetY_usesMeasuredContainerHeight()`, `fun calculatePlayerSheetCollapsedTargetY_neverPlacesSheetOutsideTopEdge()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/presentation/components/scoped` (1 files, 52 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [SheetThemeStateTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/components/scoped/SheetThemeStateTest.kt) | 52 | `class SheetThemeStateTest`, `fun resolvePlayerSheetTargetScheme_withoutAlbumArt_usesSystemScheme()`, `fun resolvePlayerSheetTargetScheme_withPendingAlbumPalette_reusesPreviousAlbumScheme()`, `fun resolvePlayerSheetTargetScheme_withReadyAlbumPalette_usesCurrentAlbumScheme()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/presentation/jellyfin/auth` (1 files, 131 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [JellyfinLoginViewModelTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/jellyfin/auth/JellyfinLoginViewModelTest.kt) | 131 | `class JellyfinLoginViewModelTest`, `fun loginWithLibraries()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/presentation/library` (1 files, 54 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LibraryTabIdTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/library/LibraryTabIdTest.kt) | 54 | `class LibraryTabIdTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/presentation/screens` (1 files, 51 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [LibraryScreenFolderNavigationAnimationTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/screens/LibraryScreenFolderNavigationAnimationTest.kt) | 51 | `class LibraryScreenFolderNavigationAnimationTest` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/presentation/viewmodel` (7 files, 1,325 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [CloudDownloadsViewModelTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/CloudDownloadsViewModelTest.kt) | 121 | `class CloudDownloadsViewModelTest`, `fun download()`, `fun song()` |
| [FileExplorerDirectoryMergeTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/FileExplorerDirectoryMergeTest.kt) | 43 | `class FileExplorerDirectoryMergeTest` |
| [ListeningStatsTrackerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/ListeningStatsTrackerTest.kt) | 117 | `class ListeningStatsTrackerTest`, `fun setUp()`, `fun tearDown()`, `fun song()` |
| [LyricsStateHolderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/LyricsStateHolderTest.kt) | 110 | `class LyricsStateHolderTest`, `fun withPersistedLyrics_replacesAlbumArtUriWhenMetadataWriteRefreshesArtworkPath()`, `fun withPersistedLyrics_keepsExistingAlbumArtUriWhenMetadataWriteDoesNotReturnOne()`, `fun fetchLyricsForSong_usesStoredLyricsWithoutRemoteFetch()`, `class RecordingLyricsLoadCallback` |
| [PlaybackStateHolderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlaybackStateHolderTest.kt) | 172 | `class PlaybackStateHolderTest`, `fun createHolder()`, `fun snapshot()` |
| [PlayerViewModelHydrationTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlayerViewModelHydrationTest.kt) | 72 | `class PlayerViewModelHydrationTest`, `fun withRepositoryHydration_fillsMissingLookupFieldsAndLyrics()`, `fun improvesLyricsLookupComparedTo_returnsTrueWhenHydrationAddsLyricsOrPath()`, `fun parsePersistedLyrics_returnsParsedLyricsForNonBlankContent()` |
| [PlayerViewModelTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/presentation/viewmodel/PlayerViewModelTest.kt) | 690 | `class PlayerViewModelTest`, `fun setUp()`, `fun tearDown()`, `fun setupViewModelWithSongs()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/ui/theme` (2 files, 421 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [ColorRolesTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/ui/theme/ColorRolesTest.kt) | 295 | `class ColorRolesTest`, `fun generateColorSchemeFromSeed_autoNeutralOutputIsPureGrayscale()`, `fun generateColorSchemeFromSeed_keepsStyleSpecificSchemeForMutedGreenSeeds()`, `fun selectSeedColorArgbFromPixels_keepsDistinctGreenAlbumsFromCollapsingIntoSharedAccent()` |
| [GenreThemeUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/ui/theme/GenreThemeUtilsTest.kt) | 126 | `class GenreThemeUtilsTest`, `fun getGenreDetailColorScheme_usesGenreCardContainerAsSeedInLightTheme()`, `fun getGenreDetailColorScheme_usesGenreCardContainerAsSeedInDarkTheme()`, `fun getGenreDetailColorScheme_forUnknownGenre_usesMonochromeScheme()` |

## `app/src/test/java/com/lostf1sh/pixelplayeross/utils` (11 files, 1,343 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [AlbumArtCacheManagerTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/AlbumArtCacheManagerTest.kt) | 70 | `class AlbumArtCacheManagerTest`, `fun snapshotFilesForCleanup_usesStableLastModifiedSnapshots()`, `fun snapshotFilesForCleanup_breaksTimestampTiesByPath()`, `class FlakyLastModifiedFile` |
| [AlbumArtUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/AlbumArtUtilsTest.kt) | 60 | `class AlbumArtUtilsTest`, `fun findExternalAlbumArtFile_returnsExplicitCoverFromDedicatedAlbumFolder()`, `fun findExternalAlbumArtFile_ignoresLooseArtworkNames()`, `fun findExternalAlbumArtFile_ignoresGenericDownloadsFolder()` |
| [AudioMetaUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/AudioMetaUtilsTest.kt) | 35 | `class AudioMetaUtilsTest`, `fun mimeTypeToFormat_mapsM4aVariants()`, `fun mimeTypeToFormat_mapsSamsungFormats()`, `fun mimeTypeToFormat_mapsUniversalFormats()` |
| [DirectoryRuleResolverTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/DirectoryRuleResolverTest.kt) | 53 | `class DirectoryRuleResolverTest`, `fun excludeThenIncludePath_pathBecomesVisibleAgain()`, `fun includeThenExcludePath_pathBecomesHidden()`, `fun nestedAllow_insideBlockedParent_isRespected()` |
| [LocalArtworkUriTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/LocalArtworkUriTest.kt) | 186 | `class LocalArtworkUriTest`, `fun resolveSongArtworkUri_convertsLegacyLocalCacheUriToStableUri()`, `fun resolveSongArtworkUri_convertsSharedArtworkUriToStableUri()`, `fun resolveSongArtworkUri_keepsRemoteArtworkUriUntouched()` |
| [LyricsImportSecurityTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/LyricsImportSecurityTest.kt) | 235 | `class LyricsImportSecurityTest`, `fun validateImportedLyricsFile_acceptsSyncedLrcAndSanitizesControlCharacters()`, `fun validateImportedLyricsFile_rejectsUnsupportedExtensions()`, `fun validateImportedLyricsFile_rejectsUnsyncedLrcContent()` |
| [LyricsUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/LyricsUtilsTest.kt) | 417 | `class LyricsUtilsTest`, `fun parseLyrics_handlesBomAtStartOfSyncedLine()`, `fun parseLyrics_handlesWhitespacesBeforeTimestamp()`, `fun parseLyrics_parsesFullSampleWithBom()` |
| [MediaItemBuilderTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/MediaItemBuilderTest.kt) | 72 | `class MediaItemBuilderTest`, `fun artworkScheme_supportsNavidromeArtworkForInternalPlayback()`, `fun artworkScheme_supportsJellyfinArtworkForInternalPlayback()`, `fun shouldPreferDirectLocalFileUri_prefersDirectFileUriForLocalM4aMediaStoreItems()` |
| [MediaStorePermissionHelperTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/MediaStorePermissionHelperTest.kt) | 60 | `class MediaStorePermissionHelperTest`, `fun isMediaStoreItemUriString_acceptsSpecificMediaStoreItems()`, `fun isMediaStoreItemUriString_rejectsCollectionUris()`, `fun canUseSongIdForMediaStoreRequest_rejectsCloudProviderUris()` |
| [MediaStoreSelectionUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/MediaStoreSelectionUtilsTest.kt) | 40 | `class MediaStoreSelectionUtilsTest` |
| [QueueUtilsTest.kt](file:///home/dharshan/PixelPlayerOSS/app/src/test/java/com/lostf1sh/pixelplayeross/utils/QueueUtilsTest.kt) | 115 | `class QueueUtilsTest`, `fun buildAnchoredShuffleQueueSuspending_handles10kSongsWithoutLosingItems()`, `fun buildAnchoredShuffleQueueSuspending_yieldsForLargeQueues()`, `fun buildAnchoredShuffleQueueSuspending_startAtZero_placesAnchorFirst()` |

## `assets` (6 files, 6,135 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [icon.png](file:///home/dharshan/PixelPlayerOSS/assets/icon.png) | 216 | - |
| [pixelplayeross_header.png](file:///home/dharshan/PixelPlayerOSS/assets/pixelplayeross_header.png) | 794 | - |
| [screenshot1.jpeg](file:///home/dharshan/PixelPlayerOSS/assets/screenshot1.jpeg) | 1229 | - |
| [screenshot2.jpeg](file:///home/dharshan/PixelPlayerOSS/assets/screenshot2.jpeg) | 1477 | - |
| [screenshot3.jpeg](file:///home/dharshan/PixelPlayerOSS/assets/screenshot3.jpeg) | 1357 | - |
| [screenshot4.jpeg](file:///home/dharshan/PixelPlayerOSS/assets/screenshot4.jpeg) | 1062 | - |

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
| [BaselineProfileGenerator.kt](file:///home/dharshan/PixelPlayerOSS/baselineprofile/src/main/java/com/lostf1sh/pixelplayeross/baselineprofile/BaselineProfileGenerator.kt) | 622 | `class BaselineProfileGenerator`, `fun generateStartupProfile()`, `fun generateBaselineProfile()`, `fun MacrobenchmarkScope()` |
| [BenchmarkEnvironment.kt](file:///home/dharshan/PixelPlayerOSS/baselineprofile/src/main/java/com/lostf1sh/pixelplayeross/baselineprofile/BenchmarkEnvironment.kt) | 126 | `fun benchmarkTargetPackageName()`, `fun MacrobenchmarkScope()`, `fun MacrobenchmarkScope()`, `fun MacrobenchmarkScope()` |
| [PlayerSheetAnimationBenchmarks.kt](file:///home/dharshan/PixelPlayerOSS/baselineprofile/src/main/java/com/lostf1sh/pixelplayeross/baselineprofile/PlayerSheetAnimationBenchmarks.kt) | 403 | `class PlayerSheetAnimationBenchmarks`, `fun playerSheetOpenCloseGestures()`, `fun androidx()`, `fun androidx()` |
| [StartupBenchmarks.kt](file:///home/dharshan/PixelPlayerOSS/baselineprofile/src/main/java/com/lostf1sh/pixelplayeross/baselineprofile/StartupBenchmarks.kt) | 56 | `class StartupBenchmarks`, `fun startupCompilationNone()`, `fun startupCompilationBaselineProfiles()`, `fun startup()` |

## `docs` (3 files, 260 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [DEPENDENCY_LICENSES.md](file:///home/dharshan/PixelPlayerOSS/docs/DEPENDENCY_LICENSES.md) | 53 | - |
| [FDROID.md](file:///home/dharshan/PixelPlayerOSS/docs/FDROID.md) | 125 | - |
| [RELEASE.md](file:///home/dharshan/PixelPlayerOSS/docs/RELEASE.md) | 82 | - |

## `docs/agents` (3 files, 111 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [domain.md](file:///home/dharshan/PixelPlayerOSS/docs/agents/domain.md) | 51 | - |
| [issue-tracker.md](file:///home/dharshan/PixelPlayerOSS/docs/agents/issue-tracker.md) | 45 | - |
| [triage-labels.md](file:///home/dharshan/PixelPlayerOSS/docs/agents/triage-labels.md) | 15 | - |

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

## `fastlane/metadata/android/en-US/images` (1 files, 484 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [icon.png](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/icon.png) | 484 | - |

## `fastlane/metadata/android/en-US/images/phoneScreenshots` (4 files, 5,125 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [1.jpeg](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/phoneScreenshots/1.jpeg) | 1229 | - |
| [2.jpeg](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/phoneScreenshots/2.jpeg) | 1477 | - |
| [3.jpeg](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/phoneScreenshots/3.jpeg) | 1357 | - |
| [4.jpeg](file:///home/dharshan/PixelPlayerOSS/fastlane/metadata/android/en-US/images/phoneScreenshots/4.jpeg) | 1062 | - |

## `gradle` (2 files, 227 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [gradle-daemon-jvm.properties](file:///home/dharshan/PixelPlayerOSS/gradle/gradle-daemon-jvm.properties) | 13 | - |
| [libs.versions.toml](file:///home/dharshan/PixelPlayerOSS/gradle/libs.versions.toml) | 214 | - |

## `gradle/wrapper` (2 files, 340 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [gradle-wrapper.jar](file:///home/dharshan/PixelPlayerOSS/gradle/wrapper/gradle-wrapper.jar) | 331 | - |
| [gradle-wrapper.properties](file:///home/dharshan/PixelPlayerOSS/gradle/wrapper/gradle-wrapper.properties) | 9 | - |

## `metadata` (1 files, 59 lines)

| File | Lines | Key Symbols / Declarations |
|---|---|---|
| [com.lostf1sh.pixelplayeross.yml](file:///home/dharshan/PixelPlayerOSS/metadata/com.lostf1sh.pixelplayeross.yml) | 59 | - |

