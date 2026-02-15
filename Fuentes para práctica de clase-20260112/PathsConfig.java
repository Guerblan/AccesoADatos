package com.ejemxml.util;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Centraliza rutas del proyecto.
 * Guardamos el XML en la carpeta "data" (fuera de resources) para poder escribir sin problemas.
 */
public final class PathsConfig {

    private PathsConfig() {}

    public static final Path DATA_DIR = Paths.get("data");
    public static final Path XML_FILE = DATA_DIR.resolve("agentes.xml");
}
