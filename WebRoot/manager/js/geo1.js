/**
 * 三级级联下拉
 */
function Dsy() {
	this.Items = {};
}
Dsy.prototype.add = function(id, iArray) {
	this.Items[id] = iArray;
}
Dsy.prototype.Exists = function(id) {
	if (typeof (this.Items[id]) == "undefined")
		return false;
	return true;
}

function change(v) {
	var str = "0";
	for (i = 0; i < v; i++) {
		str += ("_" + (document.getElementById(s[i]).selectedIndex - 1));
	}
	;
	var ss = document.getElementById(s[v]);
	with (ss) {
		length = 0;
		options[0] = new Option(opt0[v], opt0[v]);
		if (v && document.getElementById(s[v - 1]).selectedIndex > 0 || !v) {
			if (dsy.Exists(str)) {
				ar = dsy.Items[str];
				for (i = 0; i < ar.length; i++)
					options[length] = new Option(ar[i], ar[i]);
				if (v)
					options[0].selected = true;
			}
		}
		if (++v < s.length) {
			change(v);
		}
	}
}


function preselect(p_key) {
	// alert(p_key);
	var index;

	var provinces = new Array("北京市", "天津市");
	var cnt = provinces.length;
	// alert(cnt);
	for (i = 0; i < cnt; i++) {
		if (p_key == provinces[i]) {
			index = i;
			break;
		}
	}
	if (index < provinces.length) {
		document.getElementById(s[0]).selectedIndex = index + 1;
		change(1);
	}
}

var dsy = new Dsy();

dsy.add("0_0_0", [ "电气工程及其自动化2013-1", "电气工程及其自动化2013-2", "电气工程及其自动化2013-3","电气工程及其自动化2014-1", "电气工程及其自动化2014-2", "电气工程及其自动化2014-3","电气工程及其自动化2015-1", "电气工程及其自动化2015-2", "电气工程及其自动化2015-3","电气工程及其自动化2016-1", "电气工程及其自动化2016-2", "电气工程及其自动化2016-3","中澳教改2015-1","中澳教改2015-2"]);
           dsy.add("0_0_1", [ "计算机科学与技术2013-1", "计算机科学与技术2013-2", "计算机科学与技术2013-3","计算机科学与技术2013-4","计算机科学与技术2014-1", "计算机科学与技术2014-2", "计算机科学与技术2014-3", "计算机科学与技术2015-1", "计算机科学与技术2015-2", "计算机科学与技术2015-3","计算机科学与技术2015-4", "计算机科学与技术2016-1", "计算机科学与技术2016-2", "计算机科学与技术2016-3","计算机科学与技术2016-4"  ]);
           dsy.add("0_0_2", ["通信工程2013-1","通信工程2013-2","通信工程2014-1","通信工程2014-2","通信工程2014-3","通信工程2015-1","通信工程2015-2","通信工程2015-3", "通信工程2016-1","通信工程2016-2","通信工程2016-3" ]);
           dsy.add("0_0_3", [ "信息管理与信息系统2013-1", "信息管理与信息系统2013-2", "信息管理与信息系统2013-3", "信息管理与信息系统2014-1", "信息管理与信息系统2014-2", "信息管理与信息系统2015-1", "信息管理与信息系统2015-2", "信息管理与信息系统2015-3","信息管理与信息系统2016-1", "信息管理与信息系统2016-2", "信息管理与信息系统2016-3"]);
           dsy.add("0_0", [ "电气工程及其自动化","计算机科学与技术","通信工程","信息管理与信息系统"]);
          
           dsy.add("0_1_0", [ "国际经济与贸易2013-1", "国际经济与贸易2013-2", "国际经济与贸易2013-3", "国际经济与贸易2013-4", "国际经济与贸易2014-1", "国际经济与贸易2014-2", "国际经济与贸易2014-3","国际经济与贸易2015-1", "国际经济与贸易2015-2", "国际经济与贸易2015-3","国际经济与贸易2016-1", "国际经济与贸易2016-2", "国际经济与贸易2016-3"]);
           dsy.add("0_1_1", [ "金融学2014-1","金融学2014-2","金融学2014-3","金融学2015-1","金融学2015-2","金融学2015-3","金融学2016-1","金融学2016-2","金融学2016-3","金融学2016-4","中英教改2014,中英教改2015"]);
           dsy.add("0_1_2", ["会计学2013-1", "会计学2013-2", "会计学2013-3", "会计学2013-4","会计学2014-1", "会计学2014-2", "会计学2014-3", "会计学2014-4","会计学2015-1", "会计学2015-2", "会计学2015-3", "会计学2015-4","会计学2016-1", "会计学2016-2", "会计学2016-3", "会计学2016-4"]);
           dsy.add("0_1", [ "国际经济与贸易","金融学","会计学","会计" ]);
           dsy.add("0", [ "电气信息系", "财经系"]);

var s = [ "s1", "s2", "s3","s4" ];
var opt0 = [ "院系", "专业", "专业班级","课程名称" ];
function setup() {
	for (i = 0; i < s.length - 1; i++)
		document.getElementById(s[i]).onchange = new Function("change("
				+ (i + 1) + ");promptinfo();");
	change(0);
}
