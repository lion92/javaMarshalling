import com.sun.xml.internal.ws.developer.JAXBContextFactory;
import model.Personne;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class SerializeJaxb {
    public SerializeJaxb() {
    }

    public static void main(String[] args) throws JAXBException {
        //createXmlByUsingObject();
        File file=new File("C:\\Users\\kriss\\IdeaProjects\\EDT\\src\\main\\resources\\personne.xml");
        JAXBContext jaxbContext=JAXBContext.newInstance(Personne.class);
        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
        Personne personne=(Personne) unmarshaller.unmarshal(file);
        System.out.println(personne.getNom());


    }

    private static void createXmlByUsingObject() {
        JAXBContext jaxbContext = null;
        try {

            Personne personne = new Personne();
            personne.setNom("kriss");
            JAXBContext jaxbContext1=JAXBContext.newInstance(Personne.class);
            Marshaller marshaller=jaxbContext1.createMarshaller();
            marshaller.marshal(personne, new File("C:\\Users\\kriss\\IdeaProjects\\EDT\\src\\main\\resources\\personne.xml"));
            marshaller.marshal(personne, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
