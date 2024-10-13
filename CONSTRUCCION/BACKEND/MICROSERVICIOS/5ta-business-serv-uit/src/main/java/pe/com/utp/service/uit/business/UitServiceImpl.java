package pe.com.utp.service.uit.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pe.com.utp.service.uit.dto.UitResponse;
import pe.com.utp.service.uit.exception.ServiceException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import pe.com.utp.service.uit.utils.Constantes;
import pe.com.utp.service.uit.utils.UitUtils;

import java.io.IOException;

@Service
public class UitServiceImpl implements UitService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UitResponse getUit() throws IOException {

        UitResponse response = new UitResponse();

        Document doc = Jsoup.connect(Constantes.URL_SUNAT_UIT).get();

        Element tabla = doc.select("table.tb02 tr").get(1);

        if (tabla != null) {
            Element anio = tabla.select("td").get(0);
            Element valor = tabla.select("td").get(1);
            Element baseLegal = tabla.select("td").get(2);
            Element observaciones = tabla.select("td").get(3);

            response.setAnio(UitUtils.removeCommasAndPeriods(anio.text()));
            response.setValor(UitUtils.removeCommasAndPeriods(valor.text()));
            response.setBaseLegal(baseLegal.text());
            response.setObservaciones(observaciones.text());
        } else {
            throw new IOException("No se pudo encontrar la tabla de la UIT.");
        }

        return response;
    }

}
