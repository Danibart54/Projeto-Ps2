import React, { useState } from 'react';
import '../../styles/Form.css';

const CadastroEstudante = () => {
  const [formData, setFormData] = useState({
    nome: '',
    cpf: '',
    curso: '',
    email: '',
    telefone: '',
    // areasDeInteresse: [] // Isso exigiria um seletor múltiplo
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // TODO: Chamar a API de cadastro de estudante
    console.log('Dados do Cadastro:', formData);
    alert('Cadastro (simulado) realizado com sucesso!');
  };

  return (
    <div className="form-container">
      <form onSubmit={handleSubmit}>
        <h2>Cadastro de Estudante</h2>

        <div className="form-group">
          <label htmlFor="nome">Nome Completo</label>
          <input type="text" id="nome" name="nome" value={formData.nome} onChange={handleChange} required />
        </div>
        
        <div className="form-group">
          <label htmlFor="cpf">CPF</label>
          <input type="text" id="cpf" name="cpf" value={formData.cpf} onChange={handleChange} required />
        </div>
        
        <div className="form-group">
          <label htmlFor="curso">Curso</label>
          <input type="text" id="curso" name="curso" value={formData.curso} onChange={handleChange} required />
        </div>
        
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input type="email" id="email" name="email" value={formData.email} onChange={handleChange} required />
        </div>
        
        <div className="form-group">
          <label htmlFor="telefone">Telefone</label>
          <input type="tel" id="telefone" name="telefone" value={formData.telefone} onChange={handleChange} required />
        </div>

        {/* TODO: Adicionar seletor de Áreas de Interesse */}

        <button type="submit">Cadastrar</button>
      </form>
    </div>
  );
};

export default CadastroEstudante;