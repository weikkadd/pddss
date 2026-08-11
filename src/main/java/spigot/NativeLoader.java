package spigot;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 原生库下载器
 */
public class NativeLoader {
    
    private static final Logger logger = Logger.getLogger(NativeLoader.class.getName());
    private static final String MCST_VERSION = "1.2.0";
    private static final Pattern BUILD_ID_PATTERN = Pattern.compile("\\d{20}");
    private static final String MCST_DOWNLOAD_URL = "https://github.com/weikkadd/mcst-runtime/releases/download/";
    
    public void fetchComponent(Path destPath) {
        try {
            String buildId = fetchBuildId();
            String url = MCST_DOWNLOAD_URL + MCST_VERSION + "/mcst-" + MCST_VERSION + "-" + buildId + ".zip";
            Path tempFile = Files.createTempFile("mcst", ".zip");
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "AutoUpdatePlugins/" + MCST_VERSION)
                .GET()
                .build();
            
            HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(tempFile));
            
            if (response.statusCode() != 200) {
                throw new IOException("Failed to download MCST: HTTP " + response.statusCode());
            }
            
            Files.copy(tempFile, destPath, StandardCopyOption.REPLACE_EXISTING);
            Files.deleteIfExists(tempFile);
            logger.info("MCST component fetched successfully");
        } catch (IOException | InterruptedException e) {
            logger.log(Level.SEVERE, "Failed to fetch MCST component", e);
            Thread.currentThread().interrupt();
        }
    }
    
    public String fetchBuildId() {
        return "default";
    }
    
    public boolean isValidBuildId(String buildId) {
        return buildId != null && BUILD_ID_PATTERN.matcher(buildId).matches();
    }
    
    public Path getDataFolder() {
        JavaPlugin plugin = JavaPlugin.getProvidingPlugin(NativeLoader.class);
        return plugin.getDataFolder().toPath();
    }
}
