var APP = (function() {
	
	var APP = window.APP = window.APP || {
		Routers : {},
		Collections : {},
		Models : {},
		Views : {}
	};
	
	APP.Routers.Router = Backbone.Router.extend({
		routers: {
			login: 'login',
			index: 'login'
		},
		
		initialize: function () {		
			this.login();
		},

		login: function () {
			this.currentView = new APP.Views.LoginFormView();
			$('#wrapper').append(this.currentView.render().$el);
		}
	});
	
	APP.Views.LoginFormView = Backbone.View.extend({
		render: function () {
			this.$el = $($('#login-form-template').html());
			return this;
		}
	});

	APP.Models.Admin = Backbone.Model.extend({
		defaults: {
			login: '',
			password: ''
		},

		validate: function (attrs) {
			var errors = {};
			if (attrs.login === '') {
				errors.login = "Please enter login";
			}
			if (attrs.password === '') {
				errors.password = "Please enter password";
			}
			
			return errors;
		}
	});
	
	return APP;
})();

$(function () {
	var router = new APP.Routers.Router();
});