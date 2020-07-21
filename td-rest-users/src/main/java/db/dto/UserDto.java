package db.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "user")
public class UserDto {
    @XmlElement
    public int id;

    @XmlElement
    public String name;

    @XmlElement
    public String forename;

    @XmlElement
    public Date added;
}
