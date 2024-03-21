package com.intercorp.XMLReaderService.infrastructure.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
public class VerifiedXML {
    public static void correctXML(String filePath) {
        Path path = Paths.get(filePath);
        try {
            String content = new String(Files.readAllBytes(path));

            Map<String, String> replacements = new HashMap<>();
            replacements.put("Cote D\"Ivoire", "Cote D'Ivoire");
            replacements.put("Korea, Democratic People\"S Republic of", "Korea, Democratic People'S Republic of");
            replacements.put("Lao People\"S Democratic Republic", "Lao People'S Democratic Republic");


            String correctedContent = content;
            for (Map.Entry<String, String> entry : replacements.entrySet()) {
                correctedContent = correctedContent.replace(entry.getKey(), entry.getValue());
            }

            if (!content.equals(correctedContent)) {
                Files.write(path, correctedContent.getBytes());
                System.out.println("Corrected XML file " + filePath);
            } else {
                System.out.println("No corrections needed for file: " + filePath);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while correcting the file.");
            e.printStackTrace();
        }
    }

    public static boolean isXMLWellFormed(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
