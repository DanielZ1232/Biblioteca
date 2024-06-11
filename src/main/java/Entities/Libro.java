package Entities;

public class Libro {
        private String titulo;
        private String autor;
        private String ISBN;
        private int añoPublicacion;
        private boolean prestado;

        public Libro(String titulo, String autor, String ISBN, int añoPublicacion) {
            this.titulo = titulo;
            this.autor = autor;
            this.ISBN = ISBN;
            this.añoPublicacion = añoPublicacion;
            this.prestado = false;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public String getISBN() {
            return ISBN;
        }

        public int getAñoPublicacion() {
            return añoPublicacion;
        }

        public boolean isPrestado() {
            return prestado;
        }

        public void setPrestado(boolean prestado) {
            this.prestado = prestado;
        }

        @Override
        public String toString() {
            return "Libro{" +
                    "titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    ", ISBN='" + ISBN + '\'' +
                    ", añoPublicacion=" + añoPublicacion +
                    ", prestado=" + prestado +
                    '}';
        }
    }

