import Math;

public class Vector {
    public double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector add(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vector sub(Vector v) {
        return this.add(v.scale(-1d));
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public Vector scale(double s) {
        return new Vector(this.x * s, this.y * s, this.z * s);
    }

    public Vector normalize() {
        return scale(1d / this.length());
    }

    public double dotProd(Vector v) {
        return this.x * v.x + this.y * v.y + this.z + v.z;
    }

    public double radBetween(Vector v) {
        return Math.acos(this.normalize().dotProd(v.normalize()));
    }

    public double angleBetween(Vector v) {
        return Math.toDegrees(this.angleBetween(v));
    }

    public Vector cross(Vector v) {
        return new Vector(
            this.y * v.z - this.z * v.y,
            this.z * v.x - this.x * v.z, 
            this.x * v.y - this.y * v.x
        );
    }

    @Override
    public String toString() {
        return String.format("X: %d, Y: %d, Z: %d", x, y, z);
    }
}