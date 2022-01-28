module.exports = ({ env }) => ({
  auth: {
    secret: env('ADMIN_JWT_SECRET', 'b09e1dd1e8d008225835993fb723f9b1'),
  },
});
