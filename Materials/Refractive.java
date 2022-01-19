package up.edu.isgc.raytracer.Materials;

import up.edu.isgc.raytracer.Materials.Material;

import java.awt.*;
/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public class Refractive extends Material {

    private double objectRefraction=0.0;
    /** Getters, setters and constructors of the class
     */
    public Refractive(Color color, double diffuse, double shininess, double refraction) {
        super(color, diffuse, shininess);
        setObjectRefraction(refraction);
    }

    public double getObjectRefraction() {
        return objectRefraction;
    }

    public void setObjectRefraction(double refraction) {
        this.objectRefraction = refraction;
    }
}
