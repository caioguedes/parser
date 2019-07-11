package com.guedes.parser.service;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.function.Function;
import org.slf4j.Logger;

public class DirectoryWatcherService {

  private Logger logger;

  public DirectoryWatcherService(Logger logger) {
    this.logger = logger;
  }

  public void start(Path path, Function<Path, Path> handler) throws Exception {
    WatchService watchService = FileSystems.getDefault().newWatchService();

    WatchKey watchKey =
        path.register(
            watchService,
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_MODIFY);

    while (true) {
      for (WatchEvent<?> event : watchKey.pollEvents()) {
        Path file = path.resolve((Path) event.context());
        logger.info(String.format("Processing [%s] file...", file.getFileName().toString()));
        handler.apply(file);
      }
    }
  }
}
