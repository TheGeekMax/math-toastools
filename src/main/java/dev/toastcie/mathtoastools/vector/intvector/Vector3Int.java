package dev.toastcie.mathtoastools.vector.intvector;

public class Vector3Int {
    //TODO auto edit xy xz yz variables when x y or z is edited

    public int x;
    public int y;
    public int z;

    public Vector3Int(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public Vector3Int(Vector2Int xy, int z) {
        this.x = xy.x;
        this.y = xy.y;
        this.z = z;

    }

    //specials vectors

    public Vector2Int xy() {
        return new Vector2Int(this.x, this.y);
    }

    public Vector2Int xz() {
        return new Vector2Int(this.x, this.z);
    }

    public Vector2Int yz() {
        return new Vector2Int(this.y, this.z);
    }

    //calculations methods

    public Vector3Int add(Vector3Int other) {
        return new Vector3Int(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3Int subtract(Vector3Int other) {
        return new Vector3Int(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vector3Int prod(int scalar) {
        return new Vector3Int(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public Vector3Int cross(Vector3Int other) {
        return new Vector3Int(this.y * other.z - this.z * other.y, this.z * other.x - this.x * other.z, this.x * other.y - this.y * other.x);
    }

    public int dot(Vector3Int other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }
}
