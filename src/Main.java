
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;

//import java.time.LocalDate;

import clases.Estudiante;
import clases.Docente;
import clases.Libro;




public class Main {

	public static ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	public static ArrayList<Docente> docentes = new ArrayList<Docente>();
	public static ArrayList<Libro> libros = new ArrayList<Libro>();

	
    public static void main(String[] args) {
    	cargarUsuariosEnMemoria();
    	cargarLibrosEnMemoria();

    	Scanner scanner = new Scanner(System.in);
        String opcionIngresada;
        

        while (true) {
            System.out.println(
                "\n\nIngresa uno de los numeros de la lista mostrada a continuacion\n"
                + "1: Mostrar los usuarios registrados.\n"
                + "2: Mostrar los libros registrados.\n"
                + "3: Registrar nuevo usuario.\n"
                + "4: Registrar nuevo libro.\n"
                + "5: Modificar usuario.\n"
                + "6: Modificar libro.\n"
                + "7: Eliminar usuario.\n"
                + "8: Eliminar libro.\n"
                + "9: Prestar libro.\n"
                + "10: Devolver libro.\n"
                + "11: Cerrar programa.\n"
                + "Que deseas hacer? "
            );

            opcionIngresada = scanner.nextLine();


            if (opcionIngresada.equals("1")) {
            	mostrarUsuarios();
            } else if (opcionIngresada.equals("2")) {
            	mostrarLibros();
            } else if (opcionIngresada.equals("3")) {
            	registrarUsuario();
            } else if (opcionIngresada.equals("4")) {
            	registrarLibro();
            } else if (opcionIngresada.equals("5")) {
            	modificarUsuario();
            } else if (opcionIngresada.equals("6")) {
            	modificarLibro();
            } else if (opcionIngresada.equals("7")) {
            	eliminarUsuario();
            } else if (opcionIngresada.equals("8")) {
            	eliminarLibro();
            } else if (opcionIngresada.equals("9")) {
            	prestarLibro();
            } else if (opcionIngresada.equals("10")) {
            	devolverLibro();
            } else if (opcionIngresada.equals("11")) {
            	break;
            }
        }
        

        System.out.println("Programa finalizado.");
    }


    
    
    
    public static void mostrarUsuarios() {
    	for (Estudiante estudiante: estudiantes) {
    		System.out.println(estudiante.orderedData());
    		System.out.println("\n");
        }
    	
    	for (Docente docente: docentes) {
    		System.out.println(docente.orderedData());
    		System.out.println("\n");
        }
    }
    
    public static void mostrarLibros() {
    	for (Libro libro: libros) {
    		System.out.println(libro.orderedData());
    		System.out.println("\n");
        }
    }
    
    
    
    
    
    
    

    public static void registrarUsuario() {
    	Scanner scanner = new Scanner(System.in);

    	System.out.println("Ingresa el run: ");
        String run = scanner.nextLine().toUpperCase();
        if (existeUsuario(run)) {
        	System.out.println("El run ya esta registrado en otro usuario.");
        	return;
        }

        System.out.println("Ingresa el nombre completo: ");
        String nombreCompleto = scanner.nextLine();
        System.out.println("Ingresa el genero: ");
        String genero = scanner.nextLine().toUpperCase();
        
        
        String opcion;
        while (true) {
        	System.out.println("El usuario es un estudiante(1) o un docente (2)?:");
            opcion = scanner.nextLine();
            if (opcion.equals("1") || opcion.equals("2")) {
            	break;
            }
        }
        
        if (opcion.equals("1")) {
        	System.out.println("Ingresa la carrera del estudiante: ");
            String carrera = scanner.nextLine();
            Estudiante estudiante = new Estudiante(run, nombreCompleto, genero, "0", carrera);
            estudiantes.add(estudiante);
            
        	
        } else if (opcion.equals("2")) {
        	System.out.println("Ingresa el grado del docente: ");
            String grado = scanner.nextLine();
            Docente docente = new Docente(run, nombreCompleto, genero, "0", grado);
            docentes.add(docente);
        }
        
        
        guardarUsuariosEnFichero();
        System.out.println("\nUsuario registrado!!");
    }

    public static void registrarLibro() {
    	Scanner scanner = new Scanner(System.in);

    	System.out.println("Ingresa el ISBN: ");
        String ISBN = scanner.nextLine().toUpperCase();
        if (existeLibro(ISBN)) {
        	System.out.println("El IBN ya esta registrado en otro libro.");
        	
        	return;
        }
        
        System.out.println("Ingresa el titulo:");
        String titulo = scanner.nextLine();
        System.out.println("Ingresa el autor:");
        String autor = scanner.nextLine();
        
        int cantidadEnBiblioteca;
        while (true) {
        	System.out.println("Ingresa la cantidad disponible en biblioteca:");
        	String cantidadEnBibliotecaString = scanner.nextLine();
        	try {
                cantidadEnBiblioteca = Integer.parseInt(cantidadEnBibliotecaString);
                if (cantidadEnBiblioteca < 1) {
                	System.out.println("Ingresaste un numero negativo o cero.");
                } else if (cantidadEnBiblioteca >= 1) {
                	break;	
                }
        	} catch (Exception ex) {
        		System.out.println("Ingresaste algo que no es un numero");
        	}	
        }
        

        Libro libro = new Libro(ISBN, titulo, autor, cantidadEnBiblioteca, cantidadEnBiblioteca);
        libros.add(libro);
        guardarLibrosEnFichero();
        System.out.println("Libro registrado.");
    }
    
    
    
    
    
    public static void modificarUsuario() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingresa el Run del usuario que quieres modificar: ");
        String run = scanner.nextLine();
        if (!existeUsuario(run)) {
        	System.out.println("El run ingresado no esta registrado");
        	
        	return;
        }
        
        Estudiante estudiante = buscarEstudiante(run);
        Docente docente = buscarDocente(run);

        if (estudiante != null) {
        	String opcionIngresada;
        	while (true) {
        		System.out.println("Ingresa el atributo que quieres modificar:" + "\n"
            			+ "1: Nombre completo" + "\n"
            			+ "2: Genero" + "\n"
            			+ "3: Carrera" + "\n"
    					+ "Que atributo quieres modificar?"
            	);
        		opcionIngresada = scanner.nextLine();
        		if (opcionIngresada.equals("1") || opcionIngresada.equals("2") || opcionIngresada.equals("3")) {
        			break;
        		}
        	}
    		System.out.println("Ingresa el nuevo valor del atributo seleccionado:");
    		String nuevoValor = scanner.nextLine();
    		if (opcionIngresada.equals("1")) {
    			estudiante.setNombreCompleto(nuevoValor);
    		} else if (opcionIngresada.equals("2")) {
    			estudiante.setGenero(nuevoValor);
    		} else if (opcionIngresada.equals("3")) {
    			estudiante.setCarrera(nuevoValor);
    		}
        } else if (docente != null) {
        	String opcionIngresada;
        	while (true) {
        		System.out.println("Ingresa el atributo que quieres modificar:" + "\n"
            			+ "1: Nombre completo" + "\n"
            			+ "2: Genero" + "\n"
            			+ "3: Grado" + "\n"
    					+ "Que atributo quieres modificar?"
            	);
        		opcionIngresada = scanner.nextLine();
        		if (opcionIngresada.equals("1") || opcionIngresada.equals("2") || opcionIngresada.equals("3")) {
        			break;
        		}
        	}
        	System.out.println("Ingresa el nuevo valor del atributo seleccionado:");
        	System.out.println(opcionIngresada);
    		String nuevoValor = scanner.nextLine();
    		if (opcionIngresada.equals("1")) {
    			docente.setNombreCompleto(nuevoValor);
    		} else if (opcionIngresada.equals("2")) {
    			docente.setGenero(nuevoValor);
    		} else if (opcionIngresada.equals("3")) {
    			docente.setGrado(nuevoValor);
    		} 
        }
        
        guardarUsuariosEnFichero();
        System.out.println("Usuario modificado.");
    }
    
    public static void modificarLibro() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingresa el ISBN del libro que quieres modificar: ");
        String ISBN = scanner.nextLine();
        if (!existeLibro(ISBN)) {
        	System.out.println("El ISBN ingresado no esta registrado");
        	
        	return;
        }
        
        Libro libro = buscarLibro(ISBN);
    	
    	String opcionIngresada;
    	while (true) {
    		System.out.println("Ingresa el atributo que quieres modificar:" + "\n"
        			+ "1: Titulo" + "\n"
        			+ "2: Autor" + "\n"
        			+ "3: Cantidad disponible en biblioteca"
        	);
    		opcionIngresada = scanner.nextLine();
    		if (opcionIngresada.equals("1") || opcionIngresada.equals("2") || opcionIngresada.equals("3")) {
    			break;
    		}
    	}

    	System.out.println("Ingresa el nuevo valor del atributo seleccionado:");
		String nuevoValor = scanner.nextLine();
		if (opcionIngresada.equals("1")) {
			libro.setTitulo(nuevoValor);
		} else if (opcionIngresada.equals("2")) {
			libro.setAutor(nuevoValor);
		} else if (opcionIngresada.equals("3")) {
	        while (true) {
	        	try {
	                int cantidadEnBiblioteca = Integer.parseInt(nuevoValor);
	                libro.setCantidadEnBiblioteca(cantidadEnBiblioteca);
	                break;
	        	} catch (Exception ex) {
	        		System.out.println("Ingresaste algo que no es un numero");
	        		System.out.println("Ingresa el nuevo valor del atributo seleccionado:");
	        		nuevoValor = scanner.nextLine();
	        	}
	        }
		}
        
        guardarLibrosEnFichero();
        System.out.println("\nLibro modificado!!");
    }
    
    
    
    public static void eliminarUsuario() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingresa el Run del usuario a eliminar: ");
    	String run = scanner.nextLine();
    	if (!existeUsuario(run)) {
    		System.out.println("El run no esta registrado");
    		
    		return;
    	}

    	estudiantes.removeIf(estudianteEnMemoria -> estudianteEnMemoria.getRun().equals(run));
    	docentes.removeIf(docenteEnMemoria -> docenteEnMemoria.getRun().equals(run));    		

    	
    	guardarUsuariosEnFichero();
    	System.out.println("Usuario eliminado");
    }
    
    public static void eliminarLibro() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingresa el ISBN del libro a eliminar: ");
    	String ISBN = scanner.nextLine();
    	if (!existeLibro(ISBN)) {
    		System.out.println("El ISBN no esta registrado");
    		
    		return;
    	}

    	libros.removeIf(libroEnMemoria -> libroEnMemoria.getISBN().equals(ISBN));

    	
    	guardarLibrosEnFichero();
    	System.out.println("Libro eliminado");
    }
    
    
    
    
    
    
    public static void prestarLibro() {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Ingresa el ISBN del libro a prestar: ");
    	String ISBN = scanner.nextLine();
    	if (!existeLibro(ISBN)) {
    		System.out.println("El ISBN no esta registrado");
    		
    		return;
    	}

    	Libro libro = buscarLibro(ISBN);
    	
    	if (libro.getCantidadDisponiblePrestamo() == 0) {
    		System.out.println("No quedan libros para prestar");
    		
    		return;
    	}
    	
    	
    	
    	System.out.println("Ingresa el Run del usuario que recibira el libro: ");
    	String run = scanner.nextLine();
    	if (!existeUsuario(run)) {
    		System.out.println("El run no esta registrado");
    		
    		return;
    	}
    	
    	
    	libro.setCantidadDisponiblePrestamo(libro.getCantidadDisponiblePrestamo() - 1);
    	
    	Estudiante estudiante = buscarEstudiante(run);
    	Docente docente = buscarDocente(run);
    	
    	
    	
    	if (estudiante != null) {
    		if (!estudiante.getPrestamo().equals("0")) {
    			System.out.println("El usuario ingresado ya tiene un lubro prestado sin devolver");
    			return;
    		}
    		estudiante.setPrestamo(ISBN);
    	} else if (docente != null) {
    		if (!docente.getPrestamo().equals("0")) {
    			System.out.println("El usuario ingresado ya tiene un lubro prestado sin devolver");
    			return;
    		}
    		docente.setPrestamo(ISBN);
    	}

    	
    	guardarInformacionEnFicheros();
    	System.out.println("Libro prestado.");
    }

    public static void devolverLibro() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingresa el Run del usuario que quiere devolver un libro: ");
    	String run = scanner.nextLine();
    	if (!existeUsuario(run)) {
    		System.out.println("El run no esta registrado");
    		return;
    	}
    	
    	
    	
    	Estudiante estudiante = buscarEstudiante(run);
    	Docente docente = buscarDocente(run);
    	

    	Libro libro;
    	if (estudiante != null) {
    		libro = buscarLibro(estudiante.getPrestamo());
    		estudiante.setPrestamo("0");
    	} else {
    		libro = buscarLibro(docente.getPrestamo());
    		docente.setPrestamo("0");
    	}

    	libro.setCantidadDisponiblePrestamo(libro.getCantidadDisponiblePrestamo() + 1);
    	guardarInformacionEnFicheros();
    	System.out.println("Libro devuelto");
    }
    

    
    
    
    
    
    public static boolean existeUsuario(String run) {
    	Estudiante estudiante = estudiantes.stream().filter(estudianteEnLista -> estudianteEnLista.getRun().equals(run)).findAny().orElse(null);
    	Docente docente = docentes.stream().filter(docenteEnLista -> docenteEnLista.getRun().equals(run)).findAny().orElse(null);
    	return estudiante != null || docente != null;
    }
    
    public static boolean existeLibro(String ISBN) {
    	Libro libro = libros.stream().filter(libroEnLista -> libroEnLista.getISBN().equals(ISBN)).findAny().orElse(null);
    	return libro != null;  
    }


    
    
    
    
    
    public static Estudiante buscarEstudiante(String run) {
    	return estudiantes.stream().filter(estudianteEnLista -> estudianteEnLista.getRun().equals(run)).findAny().orElse(null);
    }
    
    public static Docente buscarDocente(String run) {
    	return docentes.stream().filter(docenteEnLista -> docenteEnLista.getRun().equals(run)).findAny().orElse(null);
    }

    public static Libro buscarLibro(String ISBN) {
    	return libros.stream().filter(libroEnLista -> libroEnLista.getISBN().equals(ISBN)).findAny().orElse(null);  
    }
    
    
    
    
    

    
    
    public static void cargarUsuariosEnMemoria() {
    	Scanner scanner = null;
    	File fileUsuarios = new File("src/ficheros/usuarios.txt");
    	try {
    		scanner = new Scanner(fileUsuarios);
    		while (scanner.hasNextLine()) {

    			 String rawData = scanner.nextLine();
    			 String[] arrayData = rawData.split(";");

    			 String run = arrayData[0];
    			 String nombreCompleto = arrayData[1];
    			 String genero = arrayData[2];
    			 String prestamo = arrayData[3];
    			 String estudianteDocente = arrayData[4];
    			 String carreraGrado = arrayData[5];

    			 if (estudianteDocente.equals("estudiante")) {
    				 Estudiante estudiante = new Estudiante(run, nombreCompleto, genero, prestamo, carreraGrado);
    				 estudiantes.add(estudiante);
    			 } else if (estudianteDocente.equals("docente")) {
    				 Docente docente = new Docente(run, nombreCompleto, genero, prestamo, carreraGrado);
    				 docentes.add(docente);
    			 }

    		 }
    	} catch (Exception ex) {
    		System.out.println("Error al abrir el archivo de usuarios");
    	} finally {
    		
    	}
    }

    public static void cargarLibrosEnMemoria() {
    	Scanner scanner = null;
    	File fileLibros = new File("src/ficheros/libros.txt");
    	try {
    		scanner = new Scanner(fileLibros);
    		while (scanner.hasNextLine()) {

    			 String rawData = scanner.nextLine();
    			 String[] arrayData = rawData.split(";");

    			 String ISBN = arrayData[0];
    			 String titulo = arrayData[1];
    			 String autor = arrayData[2];
    			 int cantidadEnBiblioteca = Integer.parseInt(arrayData[3]);
    			 int cantidadDisponiblePrestamo = Integer.parseInt(arrayData[4]);

				 Libro libro = new Libro(ISBN, titulo, autor, cantidadEnBiblioteca, cantidadDisponiblePrestamo);
				 libros.add(libro);
    		 }
    	} catch (Exception ex) {
    		System.out.println("Error al abrir el archivo de libros");
    	} finally {
    		
    	}
    }
    
    
    
    
    
    
    
    
    
    public static void guardarUsuariosEnFichero() {
    	try {
        	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/ficheros/usuarios.txt"));
            for (Estudiante estudiante: estudiantes) {
            	bufferedWriter.write(estudiante.rawData() + "\n");
            }
            for (Docente docente: docentes) {
            	bufferedWriter.write(docente.rawData() + "\n");
            }
            
            bufferedWriter.close();
    	} catch (IOException e) {}
    }

    public static void guardarLibrosEnFichero() {
    	try {
    		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/ficheros/libros.txt"));
    		for (Libro libro: libros) {
    			bufferedWriter.write(libro.rawData() + "\n");
    		}

    		bufferedWriter.close();
    	} catch (IOException e) {}
    }

    public static void guardarInformacionEnFicheros() {
    	guardarUsuariosEnFichero();
    	guardarLibrosEnFichero();
    }
    
    
    
    
    
}

