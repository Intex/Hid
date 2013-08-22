(function ($) {
	$.fn.hide = function (options) {
		var settings = $.extend({
			items: 'tr:not(.table-header)',
			hiddenElements: '.edit-td a, .select-td input'
		}, options || {}),
		items;

		items
			.mouseover(function () {
				$(this)
					.find(settings.hiddenElements)
					.css('visibility', 'visible');
			})

			.mouseleave(function () {
				$(this)
					.find(settings.hiddenElements)
					.css('visibility', 'hidden');
			})
	}
})(jQuery);