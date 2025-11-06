
let mockAreas = [
  { id: 1, nome: 'Desenvolvimento Frontend' },
  { id: 2, nome: 'Desenvolvimento Backend' },
  { id: 3, nome: 'DevOps' },
  { id: 4, nome: 'Design UX/UI' },
];

let mockVagas = [
  { id: 101, titulo: 'Estágio em React', area: 'Desenvolvimento Frontend', modalidade: 'Remoto', empresa: 'Tech Solutions' },
  { id: 102, titulo: 'Estágio em Java/Spring', area: 'Desenvolvimento Backend', modalidade: 'Híbrido', empresa: 'Web Services Inc.' },
  { id: 103, titulo: 'Estágio em Figma', area: 'Design UX/UI', modalidade: 'Presencial', empresa: 'Design Co.' },
];

// Função helper para simular a demora da rede
const delay = (ms) => new Promise(resolve => setTimeout(resolve, ms));

// --- API DE AUTENTICAÇÃO ---
export const apiLogin = async (email, senha, tipo) => {
  await delay(500);

  // Validação simples (substitua pela lógica real)
  if (email.includes('estudante')) {
    return { id: 1, nome: 'Ana Silva', email, perfil: 'ESTUDANTE', areasDeInteresse: ['Desenvolvimento Frontend', 'Design UX/UI'] };
  }
  if (email.includes('empresa')) {
    return { id: 2, nome: 'Tech Solutions', email, perfil: 'EMPRESA' };
  }
  if (email.includes('admin')) {
    return { id: 3, nome: 'Admin', email, perfil: 'ADMIN' };
  }
  throw new Error('Credenciais inválidas');
};

// --- API DO ADMIN ---
export const apiGetAreas = async () => {
  await delay(300);
  return [...mockAreas];
};

export const apiAddArea = async (nomeArea) => {
  await delay(300);
  const novaArea = { id: Math.random(), nome: nomeArea };
  mockAreas.push(novaArea);
  return novaArea;
};

export const apiDeleteArea = async (idArea) => {
  await delay(300);
  mockAreas = mockAreas.filter(a => a.id !== idArea);
  return { success: true };
};


export const apiCreateVaga = async (vagaData) => {
  await delay(500);
  const novaVaga = { id: Math.random(), ...vagaData };
  mockVagas.push(novaVaga);
  console.log('Nova vaga criada (simulado):', novaVaga);
  return novaVaga;
};

export const apiGetVagasPorInteresse = async (areas) => {
  await delay(600);
  return mockVagas.filter(vaga => areas.includes(vaga.area));
};