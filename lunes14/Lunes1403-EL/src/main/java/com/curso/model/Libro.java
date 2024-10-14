package com.curso.model;

	public class Libro {
		private int id;
		private String titulo;
		
		public Libro() {
			super();
		}

		public Libro(int id, String titulo) {
			super();
			this.id = id;
			this.titulo = titulo;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		
}
