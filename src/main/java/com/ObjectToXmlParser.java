package com;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

public class ObjectToXmlParser {
    public static <T> ByteArrayOutputStream getXMLSource(T data, Class<T> type) {
        JAXBContext context;

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        try {
            context = JAXBContext.newInstance(type);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(data, outStream);
        } catch (JAXBException e) {

            e.printStackTrace();
        }
        return outStream;
    }
}
