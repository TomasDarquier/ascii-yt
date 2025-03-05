# YouTube ASCII Video Player

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/)
[![WebSocket](https://img.shields.io/badge/WebSocket-Enabled-success.svg)](https://developer.mozilla.org/en-US/docs/Web/API/WebSocket)

Java application that transforms YouTube videos into ASCII art and plays them directly in your terminal. This project demonstrates advanced Java programming concepts, multimedia processing, and real-time data streaming.

## 🚀 Features

- Stream YouTube videos in real-time
- Convert video frames to ASCII art
- Terminal-based playback
- WebSocket support for real-time communication
- Configurable frame rate and resolution

<p align="center">
    <img src="docs/platformGIF.gif" alt="Platform Demo"/>
</p>

## 🛠️ Technologies Used

- **Java**: Core programming language
- **Spring Boot**: Application framework
- **WebSocket**: Real-time bidirectional communication
- **FFmpeg**: Video processing and frame extraction
- **yt-dlp**: YouTube video downloading and streaming
- **Spring WebSocket**: WebSocket implementation

## 🏗️ Architecture

The application follows a service-oriented architecture with clear separation of concerns:

- `YTDLPService`: Handles YouTube video URL processing
- `FFmpegService`: Manages video streaming and frame extraction
- `AsciiConverterService`: Converts video frames to ASCII art
- `VideoStreamHandler`: WebSocket handler for client communication

## 🔧 Prerequisites

- Java 21 or higher
- FFmpeg installed on your system
- yt-dlp installed on your system
- Maven for dependency management

## 📦 Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/youtube-ascii-player.git
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

3. Ensure FFmpeg and yt-dlp are installed:
   ```bash
   # For Ubuntu/Debian
   sudo apt-get install ffmpeg
   sudo curl -L https://github.com/yt-dlp/yt-dlp/releases/latest/download/yt-dlp -o /usr/local/bin/yt-dlp
   sudo chmod a+rx /usr/local/bin/yt-dlp
   ```

## 🚀 Usage

1. Start the application:
   ```bash
   mvn spring-boot:run
   ```

2. Connect to the WebSocket endpoint:
   ```
   ws://localhost:8080/stream
   ```

3. Send a YouTube video URL to start streaming

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create a feature branch:
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. Commit your changes:
   ```bash
   git commit -m 'Add amazing feature'
   ```
4. Push to the branch:
   ```bash
   git push origin feature/amazing-feature
   ```
5. Open a Pull Request

## 🎯 Future Improvements

- Add support for different ASCII art styles
- Implement video quality selection
- Add audio support
