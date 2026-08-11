# Analysis Report

AutoUpdatePlugins JAR 包详细分析报告

## JAR 文件信息

- **路径**: C:\Users\ASUS\Documents\Wormhole jvbdpk\autoupdateplugins-12.0.1.jar
- **大小**: 317,287 字节
- **构建时间**: 2026-08-10 03:25:35 UTC

## 类结构分析

### spigot.McstLib
- JNA 库包装类
- 方法: load(), normalize(), toAbsolutePath(), toString()

### spigot.McstService
- MCST 服务管理
- 方法: startWithConfigBlob(), stop(), getValue()
- 字段: handle (long), lib (McstLib)

### spigot.NativeLoader
- 原生库下载和加载
- 方法: fetchComponent(), isValidBuildId()
- 支持架构: amd64, aarch64, arm, arm64

### spigot.NativeRuntimeFiles
- 运行时文件管理
- 字段: soPath (Path)

### spigot.RuntimeResources
- 资源加载
- 方法: getResource(), readAllBytes()
- 资源: plugin.yml, hashes.dat

### spigot.SpigotUpdate
- 主插件类
- 方法: onEnable(), onDisable(), loadMcstRuntime()
- 日志: AutoUpdatePlugins enabled/failed

## 依赖

- Spigot API 1.18.2
- JNA 5.18.1
- Maven 3.5.0
