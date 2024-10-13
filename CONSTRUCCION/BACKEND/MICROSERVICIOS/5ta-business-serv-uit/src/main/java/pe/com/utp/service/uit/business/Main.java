package pe.com.utp.service.uit.business;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import pe.com.utp.service.uit.dto.UitResponse;
import pe.com.utp.service.uit.exception.ServiceException;
import pe.com.utp.service.uit.utils.Constantes;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ServiceException, IOException {
        getUit();
    }

    public static void getUit() throws ServiceException, IOException {

        Document doc = Jsoup.connect(Constantes.URL_SUNAT_UIT).get();

        Element tabla = doc.select("table.tb02 tr").get(1);

        if (tabla != null) {
            Element anio = tabla.select("td").get(0);
            Element valor = tabla.select("td").get(1);
            Element baseLegal = tabla.select("td").get(2);
            Element observaciones = tabla.select("td").get(3);

            System.out.println("anio: " + anio.text());
            System.out.println("valor: " + valor.text());
            System.out.println("baseLegal: " + baseLegal.text());
            System.out.println("observaciones: " + observaciones.text());

        } else {
            throw new IOException("No se pudo encontrar la tabla de la UIT.");
        }
    }

    public static int removeCommasAndPeriods(String cadenaUit){
        cadenaUit = cadenaUit.replace(Constantes.COMA, Constantes.TEXTO_VACIO);
        cadenaUit = cadenaUit.replace(Constantes.PUNTO, Constantes.TEXTO_VACIO);
        return Integer.valueOf(cadenaUit);
    }

}
