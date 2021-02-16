package com.epam.mocking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**При помощи методологии TDD написать приложение "Поиск документа в файловой системе".
 * В приложении должны быть следующие методы.
 * Просмотр содержимого текущего каталога;
 * Поиск по текущему каталогу по названию файла;
 * Построение полного пути от корня по названию файла;
 * ВАЖНО: методы реализовывать не нужно, методы должны быть замокированны на этапе написания тестов.

 * Условия:
 * Приложение должно быть maven приложением (архетип quickstart)
 * Приложение должно быть размещенно в git репозитории
 * Важно! Сначала вы пишите тесты, потом логику, тесты отдельным коммитом
 * Тесты должны быть объедены в сьюты */

public class Main {
    public static Logger logger = Logger.getLogger("log");

    public static void main(String[] args) {
        SearchingDocumentInTheFileSystem searchingDocumentInTheFileSystem = new SearchingDocumentInTheFileSystem();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Введите путь для просмотра содержимого текущего каталога");
            Path currentDirectory = Paths.get(reader.readLine());
            logger.info("Просмотр содержимого текущего каталога: " + searchingDocumentInTheFileSystem
                    .viewTheContentsOfTheCurrentDirectory(currentDirectory).toString());
            System.out.println("Введите имя файла для поиска по текущему каталогу");
            String fileName = reader.readLine();
            logger.info("Поиск по текущему каталогу по названию файла: " + searchingDocumentInTheFileSystem
                    .searchInTheCurrentDirectoryByFileName(fileName).toString());
            System.out.println("Введите имя файла длдя построения полного пути от корня");
            String fileNameToGetFullPath = reader.readLine();
            logger.info("Построение полного пути от корня по названию файла: " + searchingDocumentInTheFileSystem
                    .buildFullPathFromTheRootByTheFileName(fileNameToGetFullPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
