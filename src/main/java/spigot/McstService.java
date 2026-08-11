package spigot;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * MCST 服务包装类
 */
public class McstService {
    
    private static final Logger logger = Logger.getLogger(McstService.class.getName());
    
    private final McstLib lib;
    private final PointerByReference handleRef;
    private long handle;
    
    public McstService(McstLib lib, PointerByReference handleRef) {
        this.lib = lib;
        this.handleRef = handleRef;
    }
    
    public void startWithConfigBlob(byte[] configBlob, Path soPath) {
        try {
            PointerByReference ref = new PointerByReference();
            long result = lib.McstStartWithConfigBlob(configBlob, configBlob.length, new byte[0], 0, ref);
            
            if (result != 0) {
                throw new RuntimeException("Failed to start MCST service: error code " + result);
            }
            
            this.handle = ref.getValue().getLong(0);
            logger.info("MCST service started successfully");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error starting MCST service", e);
            throw new RuntimeException("Failed to start MCST service", e);
        }
    }
    
    public void stop() {
        if (handle != 0) {
            try {
                lib.McstStop(handle);
                handle = 0;
                logger.info("MCST service stopped");
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error stopping MCST service", e);
            }
        }
    }
    
    public Pointer getValue() {
        return handleRef.getValue();
    }
    
    public Path getSoPath() {
        return Paths.get(System.getProperty("java.io.tmpdir"), "libmcst.so");
    }
}
