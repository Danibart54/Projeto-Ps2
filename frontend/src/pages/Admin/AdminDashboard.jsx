import React from 'react';
import '../../styles/Form.css';

const AdminDashboard = () => {
  // TODO: Fazer a busca na API pelas estatísticas
  const stats = {
    empresas: 10,
    estudantes: 45,
    vagasAbertas: 8,
    vagasEncerradas: 12
  };

  return (
    <div>
      <h2>Dashboard Administrativo</h2>
      
      <div style={{ display: 'flex', gap: '20px', justifyContent: 'center' }}>
        <div className="form-container" style={{ flex: 1, textAlign: 'center' }}>
          <h3>{stats.empresas}</h3>
          <p>Empresas Cadastradas</p>
        </div>
        <div className="form-container" style={{ flex: 1, textAlign: 'center' }}>
          <h3>{stats.estudantes}</h3>
          <p>Estudantes Cadastrados</p>
        </div>
        <div className="form-container" style={{ flex: 1, textAlign: 'center' }}>
          <h3>{stats.vagasAbertas}</h3>
          <p>Vagas Abertas</p>
        </div>
      </div>
      
      <div className="form-container" style={{ marginTop: '20px' }}>
        <h3>Vagas por Área</h3>
        <p>(Gráfico pendente de implementação) [cite: 36]</p>
        {/* Aqui você usaria uma biblioteca como Chart.js ou Recharts */}
      </div>
    </div>
  );
};

export default AdminDashboard;