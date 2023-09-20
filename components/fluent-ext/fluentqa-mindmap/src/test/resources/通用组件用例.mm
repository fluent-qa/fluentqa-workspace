
<map>
  <node ID="root" TEXT="通用组件用例">
    <node TEXT="PCF" ID="6d2c524f795540b17c3ad3fd0c348d42" STYLE="bubble" POSITION="right">
      <node TEXT="分页" ID="9c2054047ce88fb57008011742062e9a" STYLE="fork">
        <node TEXT="1、默认分页数量" ID="78437f96753b8a990c5e02d807ec7869" STYLE="fork"/>
        <node TEXT="2、小于x条不出分页栏" ID="6aed86e424227b17cfa6da48bae24fe1" STYLE="fork"/>
        <node TEXT="3、仅有一页时，在首页修改分页数量" ID="ef617e657055887ab284a9b30de059de" STYLE="fork"/>
        <node TEXT="4、有多页数据时，中间页数时修改分页数量" ID="79be25d821fc52b57df2fa9925f02154" STYLE="fork"/>
        <node TEXT="5、在中间页数时，上翻" ID="e7a65949d7f4187d29aa64bafb246c41" STYLE="fork"/>
        <node TEXT="6、在中间页数时，下翻" ID="48767e2c13a4a5991cc778fed731b38a" STYLE="fork"/>
        <node TEXT="7、在首页时，上翻" ID="cf06e198ce02a86a146207fef5ec179d" STYLE="fork"/>
        <node TEXT="8、在末页时，下翻" ID="b2d6f39f97a2ac299e796243048208a6" STYLE="fork"/>
        <node TEXT="9、列表仅有一条数据时，删除该条记录" ID="ac4074f2ef1a844b9a23388e1b0aba0f" STYLE="fork"/>
        <node TEXT="10、列表有多页时&amp;末页仅有一条记录，在末页删除/归档最后一条记录" ID="44544a965de75af1cd20d701a1721c26" STYLE="fork">
          <node TEXT="列表展示 暂无数据 样式" ID="3aa4842dc20bfa446039ba6ee6de37f8" STYLE="fork"/>
          <node TEXT="列表总条数-1" ID="4012dd4210bf7d2d80ae99b1e1e2029f" STYLE="fork"/>
          <node TEXT="点击上翻一页后，下翻按钮禁用" ID="e28f606f3cd8758dc3c886ad74c29e26" STYLE="fork"/>
        </node>
        <node TEXT="11、总条数展示正确" ID="70b739425a17b7c5f24747588e2baa26" STYLE="fork"/>
        <node TEXT="12、列表分页数量联动逻辑" ID="8cb8182d69e50d67c60add447eade678" STYLE="fork"/>
      </node>
      <node TEXT="上传文件" ID="7af718881f533e5e68720fb34604dccd" STYLE="fork">
        <node TEXT="1、上传，数量限制" ID="c2e18bcc8acb01c6e9b39134cad0b658" STYLE="fork"/>
        <node TEXT="2、上传，文件大小" ID="459f05c3e58b77717072100bc267cf71" STYLE="fork">
          <node TEXT="上传文件大小超过10M，上传失败" ID="345835fe78029da91615d960bf5623af" STYLE="fork"/>
        </node>
        <node TEXT="3、上传，文件类型" ID="55eb96c5adea9c64acf2dcfc19a31e0a" STYLE="fork"/>
        <node TEXT="4、预览" ID="0c630245e2124c24d79a091d59a70f57" STYLE="fork">
          <node TEXT="不同图片格式均支持预览" ID="684eda8fb2da34c07f999b42ed47b473" STYLE="fork"/>
          <node TEXT="非图片格式不支持预览" ID="a270a8944de205b0d49dc60490826622" STYLE="fork"/>
        </node>
        <node TEXT="5、编辑，名称" ID="2dd780164ce2ac6e779af44bb13eeae9" STYLE="fork"/>
        <node TEXT="6、编辑，描述" ID="bee34a786f6daacdd62c0c3111d3115e" STYLE="fork"/>
        <node TEXT="7、编辑，后缀" ID="33f4f15c0d0495ff295cfa4773161a50" STYLE="fork">
          <node TEXT="不支持编辑" ID="206133f92e4a89a21873fb54e94c356c" STYLE="fork"/>
        </node>
        <node TEXT="8、下载" ID="cf2b3983509ed51d7f7d31b6fa0c4b64" STYLE="fork"/>
        <node TEXT="9、删除" ID="9cd594172c132b4689f8903cd7aacdb2" STYLE="fork"/>
      </node>
      <node TEXT="时间选择器" ID="47babf7f9e62b936b725a4933499b71a" STYLE="fork">
        <node TEXT="1、默认粒度" ID="675c791ee9691749e339f33d78e140de" STYLE="fork">
          <node TEXT="默认选中「按年份快选」" ID="37075bdb9926b9eba46491118b796ccb" STYLE="fork"/>
        </node>
        <node TEXT="2、上翻-年份" ID="0d6c752d1bece310e9a3301d5999a72c" STYLE="fork"/>
        <node TEXT="3、上翻-月份" ID="56df80df456c07e26e0bbcb0e1264421" STYLE="fork"/>
        <node TEXT="4、上翻-日期" ID="d3202d64d5395fe8f9e6d53a166dad02" STYLE="fork"/>
        <node TEXT="5、下翻-年份" ID="254d3e27e29668f44a43c0b7e070d327" STYLE="fork"/>
        <node TEXT="6、下翻-月份" ID="95f5e9973f863b82af8ae58e68daf764" STYLE="fork"/>
        <node TEXT="7、下翻-日期" ID="5906c86336920d59f36f844e50680201" STYLE="fork"/>
        <node TEXT="8、切换粒度" ID="1545a65cedcf39e5d3cd71d086f9f3f9" STYLE="fork"/>
        <node TEXT="9、回显" ID="c8086a8f1b83a284798689d6e7af283f" STYLE="fork">
          <node TEXT="粒度默认回显「按年份快选」" ID="8da5231caf4a829d18a349363b2a258a" STYLE="fork"/>
        </node>
      </node>
      <node TEXT="归档" ID="d4f48a56868a45cda5d3f806f227e0cf" STYLE="fork">
        <node TEXT="1、归档二次确认" ID="7e5556616cf72d42fb2850b80f4ec468" STYLE="fork"/>
        <node TEXT="2、归档后列表自动刷新，不展示被归档item" ID="5f6b0e9534159458952c7ca40802c96a" STYLE="fork"/>
        <node TEXT="3、归档后列表定位到第一条/下一条item" ID="1aa23ee223dd2f69e99d5835990079dd" STYLE="fork"/>
        <node TEXT="4、归档后，名称加上后缀" ID="22b70b56c1d90f99b2358f123c976f5b" STYLE="fork">
          <node TEXT="归档时间+“归档”" ID="65f98a3a8d4f1bafb1022268a6ff5f74" STYLE="fork"/>
        </node>
        <node TEXT="5、归档时，校验名称长度" ID="a75c58c0c76f018ff4b885356b861f9c" STYLE="fork">
          <node TEXT="名称+后缀 &gt; 长度限制，则归档失败" ID="363bcdd9370ece915a503f12e56cde88" STYLE="fork"/>
        </node>
        <node TEXT="6、复原后列表刷新" ID="6b170fa9afe2549f708c0fa00c190929" STYLE="fork"/>
      </node>
    </node>
    <node TEXT="Matrix" ID="0957f86c8dd7e88f3bdbcec3e8c626d0" STYLE="bubble" POSITION="right">
      <node TEXT="上传文件" ID="92ac31dd599b238ab72d401ea5239e50" STYLE="fork">
        <node TEXT="文件下载" ID="327b8b8242998be9730a20b7b3c8bb34" STYLE="fork">
          <node TEXT="点击下载按钮" ID="838eea3f7d624148ffee6fa67a2f4c5f" STYLE="fork">
            <node TEXT="文件下载成功" ID="beab489bf297eed0b40a7a2e52456513" STYLE="fork"/>
          </node>
          <node TEXT="预览页面点击下载按钮" ID="bcb89f565fce57871d77cc3fa9fcebb8" STYLE="fork">
            <node TEXT="文件下载成功" ID="35d77f996574fd9ac698d1ce422a688d" STYLE="fork"/>
          </node>
        </node>
        <node TEXT="文件删除" ID="d2a8fcf08e8b069d011dacf9301465c2" STYLE="fork">
          <node TEXT="点击删除按钮，再次确认" ID="5b3569266232a5ce035a3d6e778b6bf2" STYLE="fork">
            <node TEXT="文件未删除成功" ID="00d96696c3b9989f962babc723eee393" STYLE="fork"/>
          </node>
          <node TEXT="点击删除按钮，再次取消" ID="30cc607a86379ca20418de7a79ea2f2b" STYLE="fork">
            <node TEXT="文件删除成功" ID="4df14d572132590105aec9be9167463d" STYLE="fork"/>
          </node>
        </node>
        <node TEXT="文件上传" ID="f9de23566d4c6a2ba54f7041e491e77a" STYLE="fork">
          <node TEXT="上传文件大小小于等于10M" ID="f040f0cdf2ee255ed4ca5c65f7aa8dac" STYLE="fork">
            <node TEXT="上传成功" ID="5e0c7b96efae4c31a41c102ae6e881fc" STYLE="fork"/>
          </node>
          <node TEXT="上传文件大小超过10M" ID="6a941fcff73abd948c483f1c902edffa" STYLE="fork">
            <node TEXT="上传失败" ID="8aa58d38997e172fa68ec6ce69b4b198" STYLE="fork"/>
          </node>
          <node TEXT="上传两个及以上文件" ID="b5542686ba85faac52eed1aff5382a8e" STYLE="fork">
            <node TEXT="上传失败，只能上传一个文件" ID="0e639f1adc8c34559fe3a771a1e440f2" STYLE="fork"/>
          </node>
          <node TEXT="上传一个文件" ID="6f28ff95a5f1e46438a889cffb73cd84" STYLE="fork">
            <node TEXT="上传成功" ID="84d74a5d5d1354c9b12bc2b0a140c419" STYLE="fork"/>
          </node>
          <node TEXT="上传不同类型的文件" ID="288dab0c99d652d1f9bf4ae2ce9e4957" STYLE="fork">
            <node TEXT="不同类型的文件上传成功" ID="cb79ce863600ac92cd3f4601461fb098" STYLE="fork"/>
          </node>
        </node>
        <node TEXT="文件预览" ID="b38cc628bb338b99dcf25a95b0599516" STYLE="fork">
          <node TEXT="点击文件名称进入文件预览" ID="29e36052c637d8b932d98c25ac23b38c" STYLE="fork">
            <node TEXT="进入文件预览页面" ID="8c1805e73ff3915fd415310b419e5942" STYLE="fork"/>
          </node>
        </node>
        <node TEXT="文件编辑" ID="83892437f6e1ceb04f582ff87c17b8e8" STYLE="fork">
          <node TEXT="编辑文件名称并保存" ID="2137e9cbb22a11d7d4692af7e3d1b0a2" STYLE="fork">
            <node TEXT="回显则保存成功" ID="a2d089a383fdb0bc0b5ee38088a78af6" STYLE="fork"/>
          </node>
          <node TEXT="编辑文件名称不保存" ID="7a112829f96d7604675894eeba34600e" STYLE="fork">
            <node TEXT="文件未被编辑" ID="caecc29cc56dccf807e74a181313b791" STYLE="fork"/>
          </node>
          <node TEXT="编辑文件描述并保存" ID="a14204a25c31b197af2fc8f32e2d6fbb" STYLE="fork">
            <node TEXT="回显则保存成功" ID="fd035dab072d202eaae2904b9a5834f2" STYLE="fork"/>
          </node>
          <node TEXT="编辑文件描述不保存" ID="be4bf9608f0beb3456bcf6e62a684a15" STYLE="fork">
            <node TEXT="文件未被编辑" ID="45d2743db78bac4ba27e528d9f5b2979" STYLE="fork"/>
          </node>
        </node>
      </node>
      <node TEXT="搜索框" ID="f4a00ee38c0555b221e9b32a249168f9" STYLE="fork">
        <node TEXT="输入为空" ID="afd52bfaf198185b235309c174efc638" STYLE="fork">
          <node TEXT="展示全部数据" ID="1c0a2ae1e847960c9d3a4278f57e71d7" STYLE="fork"/>
        </node>
        <node TEXT="输入关键字" ID="fe6cfdbb861aad3e60482c9f6bde9fc2" STYLE="fork">
          <node TEXT="实时展示搜索结果" ID="b700f0c7d8903fbd02a6afd2f4f6b06b" STYLE="fork"/>
        </node>
        <node TEXT="输入关键字不存在" ID="30ef1349d8c978b1ac583802a349dc0d" STYLE="fork">
          <node TEXT="显示无数据" ID="4e4e548a93fd3f81063e56443cf4e7db" STYLE="fork"/>
        </node>
        <node TEXT="不区分英文大小写" ID="74f2584e6045695fc3a45b754ed578c9" STYLE="fork">
          <node TEXT="输入Z，展示Z+z的数据" ID="d446180530a81b9389a4475e5815cecd" STYLE="fork"/>
        </node>
      </node>
      <node TEXT="地理选择器" ID="d4504d5c8d585ad7f0aed6e467b07301" STYLE="fork">
        <node TEXT="原始因子库" ID="6dce1ccc17feee59103a64e84f1d26ad" STYLE="fork">
          <node TEXT="新建编辑原始因子" ID="1f13054a72ac6ff5285a9786036473b3" STYLE="fork">
            <node TEXT="全球" ID="3f26c22061f810128dceecf4bd2c1873" STYLE="fork">
              <node TEXT="默认全球" ID="96d1d4a33f647bb129f74c23346719db" STYLE="fork"/>
            </node>
            <node TEXT="大洲" ID="ecc8f487b31239fcc6311ae1ec5d0085" STYLE="fork">
              <node TEXT="可多选" ID="482210edb9aada8bc26eb09efab2c79b" STYLE="fork"/>
            </node>
            <node TEXT="国家" ID="41941fecb5e6b3d50738ef2ee634b780" STYLE="fork">
              <node TEXT="可多选" ID="ce62a4a7cc016ff5738e5504fa1f7a60" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="a77873190b91b58c34a02dbb3ab85cc6" STYLE="fork">
              <node TEXT="可多选" ID="b1571b7f89fd43ff6708d67dee9ca21c" STYLE="fork"/>
            </node>
          </node>
          <node TEXT="从cpcd新建文献因子" ID="5243dc512e928c94512e245900a16dbc" STYLE="fork">
            <node TEXT="全球" ID="c5a936fbe19d2986f202ad6c4513278f" STYLE="fork">
              <node TEXT="默认全球" ID="7561477b829d4b78bcbb8f576cd4b517" STYLE="fork"/>
            </node>
            <node TEXT="大洲" ID="83bcc5d6c70b0f66998d73270edd47b7" STYLE="fork">
              <node TEXT="可多选" ID="0941bcf6103af5e3b97c0fead465282a" STYLE="fork"/>
            </node>
            <node TEXT="国家" ID="b8c5c436900d63eedb15bb30747cb446" STYLE="fork">
              <node TEXT="可多选" ID="f27e2e3bed732ad8156dead18050e8fa" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="70ae7f9029b0925e9427188a44d83e07" STYLE="fork">
              <node TEXT="可多选" ID="1e18d85552f9e219ac1d448932dedb8a" STYLE="fork"/>
            </node>
          </node>
        </node>
        <node TEXT="引用管理（新建编辑）" ID="1e5fb26beb060679d248048abfb6fd1a" STYLE="fork">
          <node TEXT="标准" ID="7e9916556100fb68b8f5d639df9f8d40" STYLE="fork">
            <node TEXT="国家" ID="54804564faf8dc84f04d525a2d7ce2a5" STYLE="fork">
              <node TEXT="单选" ID="13ce25d397375aacc2d451258536ce29" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="326cf46440fa7a4ab4c715728b315fe5" STYLE="fork">
              <node TEXT="单选" ID="786624c7dd2b688e1f6434bbfa603d72" STYLE="fork"/>
            </node>
          </node>
          <node TEXT="报告" ID="f86c25ad06b0e20f319d423d4537dd23" STYLE="fork">
            <node TEXT="国家" ID="7b6e98c8cea7e4f185f0758958f61110" STYLE="fork">
              <node TEXT="单选" ID="5439613a3b3b2f73e0d7fc746f807617" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="291ee7db4a46d51c8ed5ec16138082a4" STYLE="fork">
              <node TEXT="单选" ID="79dff75121a96222e3be356defa71698" STYLE="fork"/>
            </node>
          </node>
          <node TEXT="学位论文" ID="110da844a119b8d6aaaf9ffbe7faed5e" STYLE="fork">
            <node TEXT="国家" ID="bf68b67fa25c485d5b83baf51df39723" STYLE="fork">
              <node TEXT="单选" ID="e1071d0958070ffc7de3fe33b6d66ec5" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="9a39fe256d98211cb2b94ffe485effb7" STYLE="fork">
              <node TEXT="单选" ID="05678dcdc3315168374e634370693871" STYLE="fork"/>
            </node>
          </node>
          <node TEXT="专利" ID="c5c2b7bea2fe7e8e1c62dcfe1b742d7d" STYLE="fork">
            <node TEXT="国家" ID="1ac6d3ccf75b6c6961873681643c52d8" STYLE="fork">
              <node TEXT="单选" ID="5516479e6fca56e5c435c8745f9d3b6e" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="0e23e5eaf62bf6281a96e463eeb59dcf" STYLE="fork">
              <node TEXT="单选" ID="607a0172d94983929ddd63ff973bd5ae" STYLE="fork"/>
            </node>
          </node>
          <node TEXT="专著，译著，普通图书或论文集" ID="1cbd3a4929672aad69d0917a38e8b53d" STYLE="fork">
            <node TEXT="国家" ID="fbfe509d0bdfc89a14fa258f8262f6ae" STYLE="fork">
              <node TEXT="单选" ID="838b880231c5cd982e679a6a9f852f23" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="fe227dbda063c2fbfb6c21ae4b88d0f1" STYLE="fork">
              <node TEXT="单选" ID="940629e48c7b03a917263a7c6b961c4d" STYLE="fork"/>
            </node>
          </node>
          <node TEXT="其他" ID="c78b7582b635e0268fc432889ce4dd31" STYLE="fork">
            <node TEXT="国家" ID="93a689b00dd308f15f201ed0be9b80fc" STYLE="fork">
              <node TEXT="单选" ID="1b52cb466bddddbae130fa6447cecec5" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="19cdf624f2f0cd9ef990f42a965fcbaa" STYLE="fork">
              <node TEXT="单选" ID="7f9f2feafa6a08d9d96d479525a1a13e" STYLE="fork"/>
            </node>
          </node>
        </node>
        <node TEXT="文献因子库" ID="01f4d12f7197a000e932ec918473cd6e" STYLE="fork">
          <node TEXT="地理代表性筛选" ID="ead5a394b32f6d71f1a1d090f1d68e73" STYLE="fork">
            <node TEXT="全球" ID="28a65afbf071ed222710ed13f5f4353d" STYLE="fork">
              <node TEXT="默认全球" ID="00df8b963cd8148e6dbd4eec7b610b22" STYLE="fork"/>
            </node>
            <node TEXT="大洲" ID="acbf36b22dc13b4e968ca13831b72276" STYLE="fork">
              <node TEXT="单选" ID="a62f8d134c7360a9bd52a9b62061c46f" STYLE="fork"/>
            </node>
            <node TEXT="国家" ID="967cc016a4ae99e632d23c1b3658b9af" STYLE="fork">
              <node TEXT="单选" ID="81a78d7d13971ba21b8d3265b45b4a86" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="293557da082ef1458ed572efb14b85b7" STYLE="fork">
              <node TEXT="单选" ID="4fc30a07b350a67cdc15ee6ff0fa5602" STYLE="fork"/>
            </node>
          </node>
          <node TEXT="从cpcd新建编辑文献因子" ID="9751ca8975660abb1252f3389dcee7a1" STYLE="fork">
            <node TEXT="全球" ID="f0131ccd955d89f35c0c8d1e3bc492e7" STYLE="fork">
              <node TEXT="默认全球" ID="08ece2254fe735465fe0fa5cb20bcb19" STYLE="fork"/>
            </node>
            <node TEXT="大洲" ID="fb4701e30237e80a2f50886afb70d81a" STYLE="fork">
              <node TEXT="可多选" ID="01fbee62ba242ec137dccd9bd92e5c77" STYLE="fork"/>
            </node>
            <node TEXT="国家" ID="55e2a17be21771e1f98a5af503976631" STYLE="fork">
              <node TEXT="可多选" ID="2274753ec3f257729a901cf34aba207d" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="39bcc73ac005bd535374664c4e717168" STYLE="fork">
              <node TEXT="可多选" ID="6e69ac7615e98c8aab597df0535c8dea" STYLE="fork"/>
            </node>
          </node>
        </node>
        <node TEXT="产品因子库" ID="27fa4359b3c4e8c2cad257930709e4e2" STYLE="fork">
          <node TEXT="新建编辑产品因子" ID="cc97f42077c673be0409108c7f7717ad" STYLE="fork">
            <node TEXT="全球" ID="1c7046ada587d1a3ecfa3cdd2c096396" STYLE="fork">
              <node TEXT="默认全球" ID="81f7e95ec7e8e6bb4fd0c991295f859d" STYLE="fork"/>
            </node>
            <node TEXT="大洲" ID="20da1e867799c453a02fff70d5d18c1c" STYLE="fork">
              <node TEXT="可多选" ID="eb13cc4ecf593e7a2ecdb6f757bc4558" STYLE="fork"/>
            </node>
            <node TEXT="国家" ID="9637a2cb33b2c6f4a319b71e58633d68" STYLE="fork">
              <node TEXT="可多选" ID="8e8c14890b62e4f8e444c91174c34416" STYLE="fork"/>
            </node>
            <node TEXT="省份地区" ID="35ffcaffae40b3edd49fd2f9031981da" STYLE="fork">
              <node TEXT="可多选" ID="155367c2f9ebf38be4e3c230f397694b" STYLE="fork"/>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</map>