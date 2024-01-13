package com.kiwiland.trains;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.kiwiland.trains.file.FileUtil;
import com.kiwiland.trains.model.Graph;
import com.kiwiland.trains.command.CommandExecutor;
import com.kiwiland.trains.command.CommandFactory;

/**
 * Entry point class.
 */
public final class Trains {

    private static final String defaultFilePath = "/input.txt";

    private Trains() {
    }

    public static void main(String[] args) {

        boolean fromResource = args.length == 0;
        String inputFilePath = fromResource ? defaultFilePath : args[0];

        Optional<List<String>> commandLines = FileUtil.readAllLinesFromFile(inputFilePath, fromResource);

        CommandExecutor executor = new CommandExecutor(System.out, new Graph(null));

        commandLines
        .ifPresent(lines -> lines
                .stream()
                .map(CommandFactory::createCommand)
                .filter(Objects::nonNull)
                .forEach(command -> command.execute(executor)));
    }

}
