/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package up.edu.isgc.raytracer.objects;

import up.edu.isgc.raytracer.IIntersectable;
import up.edu.isgc.raytracer.Intersection;
import up.edu.isgc.raytracer.Materials.Material;
import up.edu.isgc.raytracer.Vector3D;
import up.edu.isgc.raytracer.lights.Light;
import up.edu.isgc.raytracer.lights.PointLight;

/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public abstract class Object3D implements IIntersectable {

    private Vector3D position;
    private Material material;

    /**
     * Getters, setters and constructors of the class
     */


    public Vector3D getPosition() {
        return position;
    }

    public void setPosition(Vector3D position) {
        this.position = position;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Object3D(Vector3D position, Material material) {
        setPosition(position);
        setMaterial(material);
    }



}
