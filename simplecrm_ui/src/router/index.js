import Vue from 'vue'
import VueRouter from 'vue-router'
import Customers from  '@/pages/Customers.vue';
import CustomerDetail from  '@/pages/CustomerDetail.vue';
import Orders from  '@/pages/Orders.vue';
import OrderDetail from  '@/pages/OrderDetail.vue';
import Products from  '@/pages/Products.vue';
import ProductDetail from  '@/pages/ProductDetail.vue';
import OrderItems from  '@/pages/OrderItems.vue';
import OrderItemDetail from  '@/pages/OrderItemDetail.vue';
import Payments from  '@/pages/Payments.vue';
import PaymentDetail from  '@/pages/PaymentDetail.vue';

Vue.use(VueRouter)

let routes = [
	{
		// will match everything
		path: '*',
		component: () => import('../views/404.vue'),
	},
	{
		path: '/',
		name: 'Home',
			redirect: '/customers',
						},
	{
		path: '/dashboard',
		name: 'Dashboard',
		layout: "dashboard",
		// route level code-splitting
		// this generates a separate chunk (about.[hash].js) for this route
		// which is lazy-loaded when the route is visited.
		component: () => import(/* webpackChunkName: "dashboard" */ '../views/Dashboard.vue'),
	},
	{
		path: '/layout',
		name: 'Layout',
		layout: "dashboard",
		component: () => import('../views/Layout.vue'),
	},
	{
		path: '/customers',
		name: 'Customers',
		layout: "dashboard",
		component: Customers,
	},
	{
	    path: '/customer/:customerId', 
	    name: 'CustomerDetail',
		layout: "dashboard",
	    component: CustomerDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/orders',
		name: 'Orders',
		layout: "dashboard",
		component: Orders,
	},
	{
	    path: '/order/:orderId', 
	    name: 'OrderDetail',
		layout: "dashboard",
	    component: OrderDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/products',
		name: 'Products',
		layout: "dashboard",
		component: Products,
	},
	{
	    path: '/product/:productId', 
	    name: 'ProductDetail',
		layout: "dashboard",
	    component: ProductDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/orderItems',
		name: 'OrderItems',
		layout: "dashboard",
		component: OrderItems,
	},
	{
	    path: '/orderItem/:orderItemId', 
	    name: 'OrderItemDetail',
		layout: "dashboard",
	    component: OrderItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/payments',
		name: 'Payments',
		layout: "dashboard",
		component: Payments,
	},
	{
	    path: '/payment/:paymentId', 
	    name: 'PaymentDetail',
		layout: "dashboard",
	    component: PaymentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/requests/quickadd',
		name: 'QuickAdd',
		layout: "dashboard",
		meta: {
			title: 'quickadd',
			sidebarMap: ['applications'],
			breadcrumbs: ['Requests', 'QuickAdd'],
		},
		component: () => import('../pages/QuickAdd.vue'),
	},
	{
		path: '/tables',
		name: 'Tables',
		layout: "dashboard",
		component: () => import('../views/Tables.vue'),
	},
	{
		path: '/billing',
		name: 'Billing',
		layout: "dashboard",
		component: () => import('../views/Billing.vue'),
	},
	{
		path: '/rtl',
		name: 'RTL',
		layout: "dashboard-rtl",
		meta: {
			layoutClass: 'dashboard-rtl',
		},
		component: () => import('../views/RTL.vue'),
	},
	{
		path: '/Profile',
		name: 'Profile',
		layout: "dashboard",
		meta: {
			layoutClass: 'layout-profile',
		},
		component: () => import('../views/Profile.vue'),
	},
	{
		path: '/sign-in',
		name: 'Sign-In',
		component: () => import('../views/Sign-In.vue'),
	},
	{
		path: '/sign-up',
		name: 'Sign-Up',
		meta: {
			layoutClass: 'layout-sign-up',
		},
		component: () => import('../views/Sign-Up.vue'),
	},
]

// Adding layout property from each route to the meta
// object so it can be accessed later.
function addLayoutToRoute( route, parentLayout = "default" )
{
	route.meta = route.meta || {} ;
	route.meta.layout = route.layout || parentLayout ;
	
	if( route.children )
	{
		route.children = route.children.map( ( childRoute ) => addLayoutToRoute( childRoute, route.meta.layout ) ) ;
	}
	return route ;
}

routes = routes.map( ( route ) => addLayoutToRoute( route ) ) ;

const router = new VueRouter({
	mode: 'hash',
	base: process.env.BASE_URL,
	routes,
	scrollBehavior (to, from, savedPosition) {
		if ( to.hash ) {
			return {
				selector: to.hash,
				behavior: 'smooth',
			}
		}
		return {
			x: 0,
			y: 0,
			behavior: 'smooth',
		}
	}
})

export default router
