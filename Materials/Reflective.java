package up.edu.isgc.raytracer.Materials;

import java.awt.*;
/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public class Reflective extends  Material {
    /**
     * Constructor
     * @param color
     * @param diffuse
     * @param shininess
     */
    public Reflective(Color color, double diffuse, double shininess) {
        super(color, diffuse, shininess);
    }
}
