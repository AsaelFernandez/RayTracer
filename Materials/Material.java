package up.edu.isgc.raytracer.Materials;

import up.edu.isgc.raytracer.Intersection;
import up.edu.isgc.raytracer.Vector3D;
import up.edu.isgc.raytracer.lights.Light;
import up.edu.isgc.raytracer.lights.PointLight;
import up.edu.isgc.raytracer.objects.Camera;

import java.awt.*;
/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public abstract class Material {

    private Color color;
    private double diffuse;
    private double shininess;


 /** Getters, setters and constructors of the class
     */
    public Material(Color color, double diffuse, double shininess ) {
        this.color = color;
        this.diffuse = diffuse;

        this.shininess = shininess;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(double diffuse) {
        this.diffuse = diffuse;
    }

    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    /**
     * Calculate the color resultant depending non its material and conditions
     * @param light
     * @param intersection
     * @param mainCamera
     * @return
     */

    public static float[] calculateColors(Light light, Intersection intersection, Camera mainCamera) {
        float specular = 1f;
        float ambient = .05f;

        Vector3D lightRay = Vector3D.substract(light.getPosition(), intersection.getPosition());
        Vector3D cameraVector = Vector3D.substract(mainCamera.getPosition(), intersection.getPosition());
        Vector3D halfVector = Vector3D.normalize((Vector3D.add(lightRay, cameraVector)));
        float nDotL = light.getNDotL(intersection);
        float intensity = (float) light.getIntensity() * nDotL;
        if (light instanceof PointLight) {
            intensity /= Math.pow(Vector3D.magnitude(Vector3D.substract(intersection.getPosition(), light.getPosition())), 2);
        }
        float diffuseHalfVector = (float) intersection.getObject().getMaterial().getDiffuse();
        float[] colors = new float[]{intersection.getObject().getMaterial().getColor().getRed() / 255.0f, intersection.getObject().getMaterial().getColor().getGreen() / 255.0f, intersection.getObject().getMaterial().getColor().getBlue() / 255.0f};
        float[] newColor = new float[]{0.0f, 0.0f, 0.0f};


        newColor[0] = newColor[0] + colors[0] * ambient;
        newColor[1] = newColor[1] + colors[1] * ambient;
        newColor[2] = newColor[2] + colors[2] * ambient;
        newColor[0] = newColor[0] + colors[0] * intensity * (light.getMaterial().getColor().getRed() / 255.0f) * diffuseHalfVector;
        newColor[1] = newColor[1] + colors[1] * intensity * (light.getMaterial().getColor().getGreen() / 255.0f) * diffuseHalfVector;
        newColor[2] = newColor[2] + colors[2] * intensity * (light.getMaterial().getColor().getBlue() / 255.0f) * diffuseHalfVector;

        specular *= (float) Math.pow(Vector3D.dotProduct(intersection.getNormal(), halfVector), intersection.getObject().getMaterial().getShininess());
        newColor[0] = newColor[0] + colors[0] * intensity * (light.getMaterial().getColor().getRed() / 255.0f) * specular;
        newColor[1] = newColor[1] + colors[1] * intensity * (light.getMaterial().getColor().getGreen() / 255.0f) * specular;
        newColor[2] = newColor[2] + colors[2] * intensity * (light.getMaterial().getColor().getBlue() / 255.0f) * specular;
        return newColor;
    }


}