package at.dalex.fancytab.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    private String header = "This is the header";
    private String footer = "This is the footer";

    private FileConfiguration config;
    private File file;

    public Config(String fileName) {
        this.file = new File(fileName);
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public void load() {
        if (config.get("tablist.header") != null) {
            this.header = config.getString("tablist.header");
        }
        if (config.get("tablist.footer") != null) {
            this.footer = config.getString(("tablist.footer"));
        }
    }

    public void save() {
        if (header != null) {
            config.set("tablist.header", this.header);
        }
        if (footer != null) {
            config.set("tablist.footer", this.footer);
        }
    }

    public String getHeader() {
        return this.header;
    }

    public String getFooter() {
        return this.footer;
    }
}
