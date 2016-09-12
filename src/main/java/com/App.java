package com;

import com.model.ProjectTeam;
import org.apache.fop.apps.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

import static com.ObjectToXmlParser.getXMLSource;

public class App {
    // configure fopFactory as desired
    private final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

    public void createPdf(ProjectTeam data, File xsltTemplate, File pdfOutput)
            throws IOException, FOPException, TransformerException {

        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        // Setup output
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfOutput))) {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltTemplate));

            // Setup input for XSLT transformation
            Source src = new StreamSource(new ByteArrayInputStream(getXMLSource(data, ProjectTeam.class).toByteArray()));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            transformer.transform(src, res);
        }
    }
}
