package com.ejemxml.xml;

import com.ejemxml.model.Agente;
import org.jdom2.Document;
import org.jdom2.Element;

import java.util.List;

/**
 * Servicio XML con JDOM2.
 * Objetivo de esta fase:
 * 1) Crear Document desde una lista de Agente.
 * 2) Guardar el XML en data/agentes.xml con pretty format.
 * (De momento NO leemos ni modificamos: solo crear+guardar.)
 */
public class XmlAgentesServiceE {

    /**
     * TODO: Crear el Document con raíz <Agentes> y añadir cada <agente>.
     */
    public Document crearDocumento(List<Agente> agentes) {
        Element root = new Element("Agentes");
        Document doc = new Document(root);
        Element agente = new Element("agente");
        agente.setAttribute("id", "1");
        agente.addContent(new Element("alias").setText("LOPEZ"));
        agente.addContent(new Element("equipo").setText("10"));
        agente.addContent(new Element("recompensa").setText("3000.00"));
        root.addContent(agente);
      
        }
    // TODO 1: crear root = new Element("Agentes")
    // TODO 2: doc = new Document(root)
    // TODO 3: por cada agente: crear Element "agente", setAttribute id,
    // añadir hijos alias/equipo/recompensa, y addContent al root.
    return null;

    }

    /**
     * TODO: Guardar el documento en PathsConfig.XML_FILE con formato "bonito".
     */
    public void guardar(Document doc) {
        // TODO 1: asegurar carpeta data/ (createDirectories si no existe)
        // TODO 2: XMLOutputter con Format.getPrettyFormat()
        // TODO 3: output(doc, writer)
    }

    /**
     * Helper (opcional) para crear un Element <agente> desde un Agente.
     * En clase se puede hacer en sesión 1 o 2: mejora limpieza y reutilización.
     */
    private Element toElement(Agente a) {
        // TODO: construir el <agente id="..."> con 3 hijos
        return null;
    }
}