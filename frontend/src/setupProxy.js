// src/setupProxy.js
const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
  const target = process.env.REACT_APP_API_URL || 'http://localhost:8080';

  app.use(
    ['/auth', '/areas', '/api', '/vagas', '/ws'],
    createProxyMiddleware({
      target,
      changeOrigin: true,
      ws: true,
      secure: false,
      logLevel: 'warn',
      onError(err, req, res) {
        console.warn('Proxy error:', err && err.message);
        if (!res.headersSent) {
          res.writeHead(502, { 'Content-Type': 'text/plain' });
        }
        res.end('Bad gateway (proxy error)');
      },
    })
  );
};
