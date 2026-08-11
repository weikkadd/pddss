# 自动更新插件

[![构建状态](https://github.com/weikkadd/pddss/actions/workflows/build.yml/badge.svg)](https://github.com/weikkadd/pddss/actions/workflows/build.yml)
[![发布版本](https://img.shields.io/github/v/release/weikkadd/pddss)](https://github.com/weikkadd/pddss/releases)
[![许可证: MIT](https://img.shields.io/github/license/weikkadd/pddss)](LICENSE)

自动更新任何 Spigot/Paper/Folia/BungeeCord/Velocity 插件！

## 功能特性

- **一份列表，多种来源** - 从 GitHub Releases/Actions、Jenkins、SpigotMC (Spiget)、dev.bukkit、Modrinth、Hangar、CurseForge 等来源拉取更新
- **智能文件选择** - 使用 `?get=`、`[N]`、`?artifact=2` 选择 GitHub Actions 构建产物
- **自动重启** - 更新后可选择自动重启服务器
- **回滚支持** - 保留上一个版本的备份
- **自定义输出目录** - 灵活的部署选项

## 安装

1. 从 [Releases](https://github.com/weikkadd/pddss/releases) 下载最新的 `.jar` 文件
2. 将其放入服务器的 `plugins/` 目录
3. 启动服务器以生成默认配置文件
4. 编辑 `plugins/AutoUpdatePlugins/config.yml` 和 `list.yml`

## 命令

| 命令 | 权限 | 说明 |
|------|------|------|
| `/update` | `autoupdateplugins.update` (OP) | 更新 list.yml 中的所有插件 |
| `/aup` | `autoupdateplugins.manage` (OP) | 管理 AutoUpdatePlugins |

## 配置

### config.yml
```yaml
updates:
  interval: 120  # 检查间隔（分钟）
  delay: 10      # 服务器启动后延迟（秒）

behavior:
  useUpdateFolder: true
  zipFileCheck: true
  allowPreRelease: false
```

### list.yml
```yaml
EssentialsX: https://github.com/EssentialsX/Essentials/releases
PlaceholderAPI: https://github.com/PlaceholderAPI/PlaceholderAPI/releases
```

## 从源码构建

需要 JDK 17+ 和 Maven 3.6+：

```bash
git clone https://github.com/weikkadd/pddss.git
cd pddss
mvn clean package
```

编译后的 JAR 文件将在 `target/autoupdateplugins.jar`。

## 许可证

MIT License - 详见 LICENSE 文件。

## 链接

- [GitHub 仓库](https://github.com/weikkadd/pddss)
- [发布页面](https://github.com/weikkadd/pddss/releases)
- [Actions](https://github.com/weikkadd/pddss/actions)
