const app = require('express')();
const cds = require('@sap/cds');

const main = async () => {
	await cds.connect.to('db');
	const PORT = process.env.PORT || 4004;
	const scope = process.env.CDS_MULTITENANCY_SECURITY_SUBSCRIPTIONSCOPE || 'mtcallback';
	await cds.mtx.in(app);

	const provisioning = await cds.connect.to('ProvisioningService');
	provisioning.before(['UPDATE', 'DELETE', 'READ'], 'tenant', async (req) => {
		// Check for the scope of the SaaS Provisioning Service
		if (!req.user.is(scope)) {
			// Reject request
			const e = new Error('Forbidden');
			e.code = 403;
			return req.reject(e);
		}
	});

	app.listen(PORT);
}

main();