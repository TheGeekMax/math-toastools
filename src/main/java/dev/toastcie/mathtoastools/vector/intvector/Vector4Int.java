package dev.toastcie.mathtoastools.vector.intvector;

public class Vector4Int {
    //TODO auto edit xyz xyw xzw yzw (and xy xz xw yz yw zw) variables when x y z or w is edited

    public int x;
    public int y;
    public int z;
    public int w;

    public Vector4Int(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;

    }

    public Vector4Int(Vector2Int xy, int z, int w) {
        this.x = xy.x;
        this.y = xy.y;
        this.z = z;
        this.w = w;

    }

    public Vector4Int(Vector3Int xyz, int w) {
        this.x = xyz.x;
        this.y = xyz.y;
        this.z = xyz.z;
        this.w = w;

    }

    public Vector4Int(Vector2Int xy, Vector2Int zw) {
        this.x = xy.x;
        this.y = xy.y;
        this.z = zw.x;
        this.w = zw.y;

    }

    //specials vectors

    public Vector2Int xy() {
        return new Vector2Int(this.x, this.y);
    }

    public Vector2Int xz() {
        return new Vector2Int(this.x, this.z);
    }

    public Vector2Int xw() {
        return new Vector2Int(this.x, this.w);
    }

    public Vector2Int yz() {
        return new Vector2Int(this.y, this.z);
    }

    public Vector2Int yw() {
        return new Vector2Int(this.y, this.w);
    }

    public Vector2Int zw() {
        return new Vector2Int(this.z, this.w);
    }

    public Vector3Int xyz() {
        return new Vector3Int(this.x, this.y, this.z);
    }

    public Vector3Int xyw() {
        return new Vector3Int(this.x, this.y, this.w);
    }

    public Vector3Int xzw() {
        return new Vector3Int(this.x, this.z, this.w);
    }

    public Vector3Int yzw() {
        return new Vector3Int(this.y, this.z, this.w);
    }

    //calculations methods

    public Vector4Int add(Vector4Int other) {
        return new Vector4Int(this.x + other.x, this.y + other.y, this.z + other.z, this.w + other.w);
    }

    public Vector4Int subtract(Vector4Int other) {
        return new Vector4Int(this.x - other.x, this.y - other.y, this.z - other.z, this.w - other.w);
    }

    public Vector4Int prod(int scalar) {
        return new Vector4Int(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }

    public Vector4Int cross(Vector4Int other) {
        return new Vector4Int(this.y * other.z - this.z * other.y, this.z * other.x - this.x * other.z, this.x * other.y - this.y * other.x, 0);
    }

    public int dot(Vector4Int other) {
        return this.x * other.x + this.y * other.y + this.z * other.z + this.w * other.w;
    }
}
