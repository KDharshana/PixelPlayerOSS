
<p align="center">
  <img src="assets/pixelplayeross_header.png" alt="PixelPlayerOSS — open-source music player for Android"/>
</p>

<p align="center">
  <a href="https://github.com/PixelPlayerHQ/PixelPlayerOSS/releases/latest">
    <img src="https://img.shields.io/github/v/release/PixelPlayerHQ/PixelPlayerOSS?include_prereleases&logo=github&style=for-the-badge&label=Latest%20Release" alt="Latest release">
  </a>
  <a href="https://f-droid.org/packages/com.lostf1sh.pixelplayeross/">
    <img src="https://img.shields.io/f-droid/v/com.lostf1sh.pixelplayeross?logo=fdroid&style=for-the-badge&label=F-Droid" alt="F-Droid version">
  </a>
  <a href="https://github.com/PixelPlayerHQ/PixelPlayerOSS/releases">
    <img src="https://img.shields.io/github/downloads/PixelPlayerHQ/PixelPlayerOSS/total?logo=github&style=for-the-badge" alt="Total downloads">
  </a>
  <a href="https://github.com/sponsors/lostf1sh">
    <img src="https://img.shields.io/badge/Sponsor-GitHub%20Sponsors-EA4AAA?style=for-the-badge&logo=githubsponsors&logoColor=white" alt="Sponsor on GitHub Sponsors">
  </a>
  <a href="https://github.com/dharshan-X">
    <img src="https://img.shields.io/badge/Maintained%20by-dharshan--X-007ACC?style=for-the-badge&logo=github&logoColor=white" alt="Maintained by dharshan-X">
  </a>
  <img src="https://img.shields.io/badge/Android-11%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android 11+">
  <img src="https://img.shields.io/badge/License-GPLv3-blue?style=for-the-badge" alt="GPLv3 license">
</p>

<p align="center">
  <img src="assets/screenshot1.jpeg" alt="PixelPlayerOSS home screen" width="205"/>
  <img src="assets/screenshot2.jpeg" alt="PixelPlayerOSS now playing screen" width="205"/>
  <img src="assets/screenshot3.jpeg" alt="PixelPlayerOSS library screen" width="205"/>
  <img src="assets/screenshot4.jpeg" alt="PixelPlayerOSS lyrics screen" width="205"/>
</p>

## What It Is

PixelPlayerOSS is an open-source Android music player focused on local playback, self-hosted streaming, client-side YouTube Music discovery, expressive Material 3 UI, and privacy-respecting online lookups.

The app is fully functional offline by default. All online integrations (streaming, metadata, lyrics, scrobbling) are modular, client-side, and user-configurable.

Package name: `com.lostf1sh.pixelplayeross`

## Why This Exists

PixelPlayerOSS keeps the player strictly FOSS-oriented and private:

- **No Proprietary Trackers**: Stripped of Firebase, Crashlytics, Google Play Services runtime dependencies, Google Drive, Gemini, and Play Store billing.
- **Client-Side & Standalone**: Streaming and metadata extraction run directly on-device without relying on centralized or privacy-compromising intermediary proxy servers.
- **Unified Audio Experience**: Seamlessly integrates local device storage, self-hosted media servers (Navidrome, Jellyfin), and YouTube Music into a single unified queue, playlist engine, and UI.

## Features

| Area | Highlights |
| --- | --- |
| **Playback Engine** | Custom `DualPlayerEngine` powered by AndroidX Media3 & ExoPlayer, gapless playback, customizable crossfade, transition curves, audio offload stall recovery, hardware decoder optimization, smart queue, and sleep timer. |
| **Search & Discovery** | High-performance FTS4 SQLite local search combined with progressive online YouTube Music search, unified infinite scrolling, live filter chips (Songs, Albums, Artists, Playlists), and persistent search history. |
| **Streaming & Cloud** | Client-side YouTube Music (Innertube engine, continuous radio mix feeds, 1024px Ultra-HD artwork), self-hosted Navidrome/Subsonic & Jellyfin sync/streaming, and ListenBrainz real-time scrobbling. |
| **Unified Library** | Single cohesive library for Local, Cloud, and YouTube Music songs, albums, artists, genres, playlists, and favorites/likes with quick source filtering (`Unified`, `Local`, `YouTube Music`). |
| **Offline & Caching** | Dedicated offline download manager (`CloudOfflineRepository`), persistent stream metadata caching, and automated pre-buffering for gapless streaming. |
| **Lyrics** | Embedded tags, local `.lrc` files, synchronized YouTube Music transcript lyrics, LRCLIB online time-synced lyrics lookup, and interactive lyrics viewer/editor. |
| **Artwork & Visuals** | Ultra-HD 1024px album artwork upscaler, Material You dynamic color palette extraction, customizable UI themes, and glanceable Home Screen widgets. |
| **Backup & Metadata** | Complete export/import for preferences, playlists, favorites, lyrics, and play statistics; on-demand MusicBrainz metadata enrichment and TagLib audio tag editing. |

## Online Services

PixelPlayerOSS separates offline playback from network lookups.

| Service | Purpose | Default |
| --- | --- | --- |
| **YouTube Music (Innertube)** | Client-side online search, song streaming, radio queues, artist/album exploration, and 1024px HD artwork | Enabled (No account required) |
| **Navidrome / Subsonic** | Self-hosted library synchronization, streaming, and offline track downloads | User login required |
| **Jellyfin** | Self-hosted server streaming, library sync, and offline downloads | User login required |
| **ListenBrainz** | Real-time playback scrobbling and listening history tracking | User token required |
| **LRCLIB** | Online synchronized lyrics lookup when local or embedded lyrics are missing | Off (Opt-in) |
| **MusicBrainz** | On-demand metadata matching and track/artist identifier enrichment | On-demand |
| **Deezer** | Fetch missing artist artwork and cache it locally | Off (Opt-in) |

Optional services can be toggled during first-run setup or from `Settings > Music Management > Optional online services`.

## Requirements

| Requirement | Version |
| --- | --- |
| Android | 11 or newer (API 30+) |
| JDK | 21 |
| Android SDK | compile/target 37 |

## Build From Source

Clone the repository:

```sh
git clone https://github.com/PixelPlayerHQ/PixelPlayerOSS.git
cd PixelPlayerOSS
```

Build the debug APK:

```sh
JAVA_HOME=/usr/lib/jvm/java-21-openjdk ./gradlew :app:assembleDebug
```

Build one universal debug APK for local installation:

```sh
JAVA_HOME=/usr/lib/jvm/java-21-openjdk ./gradlew :app:assembleDebug -Ppixelplayer.enableAbiSplits=false
```

Build a signed/unsigned release APK:

```sh
JAVA_HOME=/usr/lib/jvm/java-21-openjdk ./gradlew :app:assembleRelease
```

Run unit tests:

```sh
JAVA_HOME=/usr/lib/jvm/java-21-openjdk ./gradlew :app:testDebugUnitTest
```

Generate baseline profiles with a connected device or emulator:

```sh
JAVA_HOME=/usr/lib/jvm/java-21-openjdk ./gradlew :baselineprofile:generateBaselineProfile
```

## Download

PixelPlayerOSS is available on F-Droid:

<a href="https://f-droid.org/packages/com.lostf1sh.pixelplayeross/">
  <img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png" alt="Get it on F-Droid" height="80">
</a>

GitHub releases are available at:

```text
https://github.com/PixelPlayerHQ/PixelPlayerOSS/releases
```

Obtainium app ID:

```text
com.lostf1sh.pixelplayeross
```

Public releases are published on a regular cadence when `main` passes all release checks.

### Alpha builds

Every merge into `main` automatically publishes a pre-release tagged like `v0.3.0-alpha.N` on the [releases page](https://github.com/PixelPlayerHQ/PixelPlayerOSS/releases).

- `arm64-v8a`: Fits modern 64-bit devices.
- `armeabi-v7a`: For older 32-bit devices.

## Tech Stack

| Area | Technology |
| --- | --- |
| **Language** | Kotlin 2.4 |
| **UI & Design** | Jetpack Compose, Material 3 Expressive, Glance App Widgets |
| **Playback** | AndroidX Media3, ExoPlayer, custom `DualPlayerEngine` |
| **Database** | Room SQLite with FTS4 Full-Text Search |
| **Dependency Injection** | Dagger Hilt |
| **Preferences** | Jetpack DataStore |
| **Background Work** | WorkManager |
| **Networking** | Retrofit 2, OkHttp 4, pure-Kotlin Innertube extractor |
| **Image Loading** | Coil 3 |
| **Audio Metadata** | TagLib |

## Project Structure

```text
app/src/main/java/com/lostf1sh/pixelplayeross/
├── data/             # Room DB (FTS4), repositories, preferences, services, workers, Innertube
├── di/               # Dagger Hilt modules and dependency providers
├── presentation/     # Jetpack Compose screens, components, navigation, ViewModels, state holders
├── ui/               # Material 3 Theme, dynamic color palettes, Glance home widgets
└── utils/            # Formats, audio envelopes, helpers, extensions

baselineprofile/      # Macrobenchmarks and baseline profile generators
```

## Contributing

Contributions are welcome! Open an issue or pull request with focused changes and include test/build verification results.

Useful local checks:

```sh
JAVA_HOME=/usr/lib/jvm/java-21-openjdk ./gradlew :app:compileDebugKotlin
JAVA_HOME=/usr/lib/jvm/java-21-openjdk ./gradlew :app:lintDebug
JAVA_HOME=/usr/lib/jvm/java-21-openjdk ./gradlew :app:testDebugUnitTest
```

Release process: [docs/RELEASE.md](docs/RELEASE.md) | F-Droid notes: [docs/FDROID.md](docs/FDROID.md) | Privacy policy: [PRIVACY.md](PRIVACY.md) | Security policy: [SECURITY.md](SECURITY.md)

## License

PixelPlayerOSS is licensed under the [GNU General Public License v3.0](LICENSE) (`SPDX-License-Identifier: GPL-3.0-or-later`).

```text
PixelPlayerOSS
Copyright (C) 2026 Theo Vilardo

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
```

Distributed APKs include third-party components under their own licenses. In particular, the optional FFmpeg decoder dependency `org.jellyfin.media3:media3-ffmpeg-decoder` is GPL-3.0; see [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md).

<p align="center">
  Maintained by <a href="https://github.com/dharshan-X">dharshan-X</a>
</p>
