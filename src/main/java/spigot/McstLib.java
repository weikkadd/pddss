package spigot;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * JNA 库包装 - MCST 原生库接口
 */
public interface McstLib extends Library {
    
    McstLib INSTANCE = Native.load(
        Paths.get(System.getProperty("java.io.tmpdir"), "libmcst.so").normalize().toAbsolutePath().toString(),
        McstLib.class
    );
    
    /**
     * 释放原生库分配的字符串
     */
    void McstFreeCString(Pointer str);
    
    /**
     * 使用配置 blob 启动 MCST 服务
     */
    long McstStartWithConfigBlob(byte[] data, int dataLen, byte[] args, int argLen, PointerByReference outHandle);
    
    /**
     * 停止 MCST 服务
     */
    void McstStop(long handle);
}
