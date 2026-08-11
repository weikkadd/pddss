package spigot;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 原生运行时文件路径记录类
 */
public record NativeRuntimeFiles(Path soPath) {
    public Path getSoPath() {
        return soPath;
    }
}
