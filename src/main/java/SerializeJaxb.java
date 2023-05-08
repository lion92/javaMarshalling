import model.Cours;
import model.Matiere;
import model.Planning;
import model.Scheduled;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class SerializeJaxb {
    public SerializeJaxb() {
    }

    public static void main(String[] args) throws JAXBException {
        //createXmlByUsingObject();
        readXml();


    }

    private static void readXml() throws JAXBException {
        File file=new File("C:\\Users\\kriss\\IdeaProjects\\EDT\\src\\main\\resources\\planning.xml");
        JAXBContext jaxbContext=JAXBContext.newInstance(Planning.class);
        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
        Planning planning=(Planning) unmarshaller.unmarshal(file);
        System.out.println(planning.toString());
    }

    private static void createXmlByUsingObject() {
        JAXBContext jaxbContext = null;
        try {
            Planning planning=new Planning();
            ArrayList<Cours> listCour=new ArrayList<Cours>();
            listCour.add(new Cours(new Matiere("math","kriss"), new Scheduled(1)));
            planning.setCours(listCour);
            JAXBContext jaxbContext1=JAXBContext.newInstance(Planning.class);
            Marshaller marshaller=jaxbContext1.createMarshaller();
            marshaller.marshal(planning, new File("C:\\Users\\kriss\\IdeaProjects\\EDT\\src\\main\\resources\\planning.xml"));
            marshaller.marshal(planning, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
