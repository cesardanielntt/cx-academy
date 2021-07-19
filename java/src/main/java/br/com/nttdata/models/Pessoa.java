package br.com.nttdata.models;

    public class Pessoa {
        protected String id;
        protected String nome;
        protected String email;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setSobrenome(String assis) {
        }

        public void setIdade(String i) {
        }
    }
