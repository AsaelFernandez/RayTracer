package up.edu.isgc.raytracer.lights;

import up.edu.isgc.raytracer.Intersection;
import up.edu.isgc.raytracer.Materials.Material;
import up.edu.isgc.raytracer.Vector3D;
/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public class SpotLight extends PointLight {

    private double angle;
    private  Vector3D direction;
    /** Getters, setters and constructors of the class
     */
    public SpotLight(Vector3D position, Material material, double intensity, Vector3D direction) {
        super(position, material, intensity);
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Vector3D getDirection() {
        return direction;
    }

    public void setDirection(Vector3D direction) {
        this.direction = direction;
    }
}

