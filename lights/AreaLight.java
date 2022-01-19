package up.edu.isgc.raytracer.lights;

import up.edu.isgc.raytracer.Materials.Material;
import up.edu.isgc.raytracer.Vector3D;
import up.edu.isgc.raytracer.objects.Object3D;
/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public class AreaLight extends PointLight{
    Object3D object;
    /** Getters, setters and constructors of the class
     */
    public Object3D getObject() {
        return object;
    }

    public void setObject(Object3D object) {
        this.object = object;
    }

    public AreaLight(Vector3D position, Material material, double intensity, Object3D object) {
        super(position, material, intensity);
        setObject(object);
    }
}
