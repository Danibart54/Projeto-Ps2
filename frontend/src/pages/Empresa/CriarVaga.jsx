import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { apiCreateVaga } from '../../api/simulatedApi';
import '../../styles/Form.css';

const CriarVaga = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    titulo: '',
    descricao: '',
    area: '',
    localizacao: '',
    modalidade: 'presencial', // Valor padrão
    cargaHoraria: '',
    requisitos: ''
  });
  const [loading, setLoading] = useState(false);

  // Um único handler para todos os inputs
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    
    try {
      await apiCreateVaga(formData);
      alert('Vaga criada com sucesso!');
      navigate('/painel-empresa'); // Redireciona para o painel
    } catch (error) {
      alert('Erro ao criar vaga.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="form-container">
      <form onSubmit={handleSubmit}>
        <h2>Ofertar Nova Vaga</h2>

        {/* Título */}
        <div className="form-group">
          <label htmlFor="titulo">Título da Vaga</label>
          <input type="text" id="titulo" name="titulo" value={formData.titulo} onChange={handleChange} required />
        </div>

        {/* Descrição */}
        <div className="form-group">
          <label htmlFor="descricao">Descrição</label>
          <textarea id="descricao" name="descricao" value={formData.descricao} onChange={handleChange} required />
        </div>

        {/* Área (Idealmente um <select> populado pela API de Áreas) */}
        <div className="form-group">
          <label htmlFor="area">Área</label>
          <input type="text" id="area" name="area" value={formData.area} onChange={handleChange} placeholder="Ex: Desenvolvimento Frontend" required />
        </div>

        {/* Localização */}
        <div className="form-group">
          <label htmlFor="localizacao">Localização</label>
          <input type="text" id="localizacao" name="localizacao" value={formData.localizacao} onChange={handleChange} placeholder="Ex: São Paulo, SP" required />
        </div>

        {/* Modalidade */}
        <div className="form-group">
          <label htmlFor="modalidade">Modalidade</label>
          <select id="modalidade" name="modalidade" value={formData.modalidade} onChange={handleChange}>
            <option value="presencial">Presencial</option>
            <option value="remoto">Remoto</option>
            <option value="hibrido">Híbrido</option>
          </select>
        </div>

        {/* Carga Horária */}
        <div className="form-group">
          <label htmlFor="cargaHoraria">Carga Horária (horas/semana)</label>
          <input type="number" id="cargaHoraria" name="cargaHoraria" value={formData.cargaHoraria} onChange={handleChange} required />
        </div>

        {/* Requisitos */}
        <div className="form-group">
          <label htmlFor="requisitos">Requisitos (separados por vírgula)</label>
          <input type="text" id="requisitos" name="requisitos" value={formData.requisitos} onChange={handleChange} />
        </div>

        <button type="submit" disabled={loading}>
          {loading ? 'Publicando...' : 'Publicar Vaga'}
        </button>
      </form>
    </div>
  );
};

export default CriarVaga;