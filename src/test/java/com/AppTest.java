package com;

import com.model.ProjectMember;
import com.model.ProjectTeam;
import org.apache.fop.apps.FOPException;
import org.junit.Test;

import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.URISyntaxException;

public class AppTest {
    public static ProjectTeam createSampleProjectTeam() {
        ProjectTeam team = new ProjectTeam();
        team.setProjectName("Rule the Galaxy");
        team.addMember(new ProjectMember(
                "Emperor Palpatine", "lead", "palpatine@empire.gxy", true));
        team.addMember(new ProjectMember(
                "Lord Darth Vader", "Jedi-Killer", "vader@empire.gxy", false));
        team.addMember(new ProjectMember(
                "Grand Moff Tarkin", "Planet-Killer", "tarkin@empire.gxy", true));
        team.addMember(new ProjectMember(
                "Admiral Motti", "Death Star operations", "motti@empire.gxy", false));
        return team;
    }

    @Test
    public void testRunGeneratePDF() throws TransformerException, IOException, FOPException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        File template = new File(classLoader.getResource("template.xsl").getFile());
        File out = new File("Report.pdf");

        new App().createPdf(createSampleProjectTeam(), template, out);
    }

    @Test
    public void writeObjectAsXml() throws Exception {
        final ByteArrayOutputStream xmlSource = ObjectToXmlParser.getXMLSource(createSampleProjectTeam(), ProjectTeam.class);

        try (OutputStream outputStream = new FileOutputStream("text.xml")) {
            xmlSource.writeTo(outputStream);
        }
    }
}
