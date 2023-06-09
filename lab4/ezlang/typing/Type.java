package typing;

// Enumeração dos tipos primitivos que podem existir em EZLang.
public enum Type {
	INT_TYPE,
    REAL_TYPE,
    BOOL_TYPE,
    STR_TYPE;

	public String toString() {
		switch(this) {
			case INT_TYPE:	return "int";
			case REAL_TYPE: return "real";
			case BOOL_TYPE: return "bool";
			case STR_TYPE: 	return "string";
			default:
				System.err.println("ERROR: Fall through in Type enumeration!");
				System.exit(1);
				return ""; // Never reached.
		}
	}

	public int toInteger() {
		switch(this) {
			case INT_TYPE:	return 0;
			case REAL_TYPE: return 1;
			case BOOL_TYPE: return 2;
			case STR_TYPE: 	return 3;
			default:
				System.err.println("ERROR: Fall through in Type enumeration!");
				System.exit(1);
				return -1; // Never reached.
		}
	}
}
