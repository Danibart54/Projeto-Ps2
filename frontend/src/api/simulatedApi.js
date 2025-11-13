// Use REACT_APP_API_URL at build/dev time, otherwise use relative path so
// requests are sent to the same origin (works with CRA proxy and Codespaces).
const BASE_URL = process.env.REACT_APP_API_URL || "";

async function request(path, { method = 'GET', body, headers = {} } = {}) {
  const opts = {
    method,
    headers: { 'Content-Type': 'application/json', ...headers },
  };
  if (body !== undefined) opts.body = JSON.stringify(body);

  const fullPath = BASE_URL + path;

  try {
    const res = await fetch(fullPath, opts);
    
    if (!res.ok) {
      const text = await res.text();
      // CORREÇÃO ABAIXO: Uso de crases (`) para interpolação
      throw new Error(`${res.status} ${res.statusText}: ${text}`);
    }

    const contentType = res.headers.get('content-type') || '';
    if (contentType.includes('application/json')) {
      return await res.json();
    }
    return await res.text();
  } catch (err) {
    console.error("Falha na chamada da API:", err);
    throw err;
  }
}


export const get = (path) => request(path, { method: 'GET' });
export const post = (path, body) => request(path, { method: 'POST', body });
export const put = (path, body) => request(path, { method: 'PUT', body });
export const del = (path) => request(path, { method: 'DELETE' });

// --- API DE AUTENTICAÇÃO ---
export const apiLogin = async (email, senha, tipo) => {
  return post("/auth/login", { email, senha, tipo });
};

// --- API DO ADMIN ---
export const apiGetAreas = async () => {
  return get("/areas");
};

export const apiAddArea = async (nomeArea) => {
  return post("/areas", { nome: nomeArea });
};

export const apiDeleteArea = async (idArea) => {
  // CORREÇÃO ABAIXO: Uso de crases (`)
  return del(`/areas/${idArea}`);
};


export const apiCreateVaga = async (vagaData) => {
  return post("/vagas", vagaData);
};

export const apiGetVagasPorInteresse = async (areas) => {
  return post("/vagas/interesses", { areas });
};