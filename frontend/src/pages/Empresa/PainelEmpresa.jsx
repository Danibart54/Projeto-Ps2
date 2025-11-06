import React from 'react';
import { useAuth } from '../../contexts/AuthContext';
import { Link } from 'react-router-dom';

const PainelEmpresa = () => {
  const { user } = useAuth();

  // ADICIONAMOS A MESMA VERIFICAÇÃO:
  if (!user) {
    return <p>Carregando dados da empresa...</p>;
  }

  // Agora o código abaixo é seguro:
  return (
    <div>
      <h2>Painel da Empresa: {user.nome}</h2>
      
      <Link to="/criar-vaga" style={{
        backgroundColor: '#28a745',
        color: 'white',
        padding: '10px 15px',
        textDecoration: 'none',
        borderRadius: '5px',
        display: 'inline-block',
        marginBottom: '20px'
      }}>
        + Criar Nova Vaga
      </Link>

      <h3>Seus Candidatos Recentes</h3>
      <div className="form-container" style={{ textAlign: 'center' }}>
        <p>Nenhum candidato inscrito nas suas vagas ainda.</p>
        <p>(Funcionalidade de listagem de candidatos pendente de implementação)</p>
      </div>
    </div>
  );
};

export default PainelEmpresa;