package cn.pw.pf.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

/**
 * 获取图形验证码
 *
 * @author: libin
 * @date: 19:41 2018/9/20
 */
@RestController
@RequestMapping("/captcha")
@Slf4j
public class CaptchaController extends BaseController {

    private static int W = 70;

    private static int H = 26;

    @RequestMapping
    public void captcha(String width, String height, HttpServletResponse response, Model model) {
        OutputStream out = null;
        int w = 70;
        int h = 26;
        try {
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            if (StringUtils.isNotBlank(width) && StringUtils.isNotBlank(height)
                    && StringUtils.isNumeric(width) && StringUtils.isNumeric(height)) {
                int tempw = NumberUtils.toInt(width);
                int temh = NumberUtils.toInt(height);
                w = tempw >= W ? W : tempw;
                h = temh >= H ? H : temh;
            }
            BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            // 生成背景
            g.setColor(getRandColor(220, 250));
            g.fillRect(0, 0, w, h);
            // 加入干扰线条
            for (int i = 0; i < 8; i++) {
                g.setColor(getRandColor(40, 150));
                Random random = new Random();
                int x = random.nextInt(w);
                int y = random.nextInt(h);
                int x1 = random.nextInt(w);
                int y1 = random.nextInt(h);
                g.drawLine(x, y, x1, y1);
            }
            String s = createCharacter(g);// 生成字符
            //   SessionUtils.put(Constants.SESSION_KEY_CAPTCHA, s);
            g.dispose();
            out = response.getOutputStream();
            ImageIO.write(image, "JPEG", out);
            out.close();
        } catch (Exception e) {
            logger.error("Write Captcha Error", e);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    private Color getRandColor(int fc, int bc) {
        int f = fc;
        int b = bc;
        Random random = new Random();
        if (f > 255) {
            f = 255;
        }
        if (b > 255) {
            b = 255;
        }
        return new Color(f + random.nextInt(b - f), f + random.nextInt(b - f), f + random.nextInt(b - f));
    }

    private String createCharacter(Graphics g) {
        char[] codeSeq =
                {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};
        String[] fontTypes =
                {"\u5b8b\u4f53", "\u65b0\u5b8b\u4f53", "\u9ed1\u4f53", "\u6977\u4f53", "\u96b6\u4e66"};
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String r = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);
            g.setColor(new Color(50 + random.nextInt(100), 50 + random.nextInt(100), 50 + random.nextInt(100)));
            g.setFont(new Font(fontTypes[random.nextInt(fontTypes.length)], Font.BOLD, 26));
            g.drawString(r, 15 * i + 5, 19 + random.nextInt(8));
            s.append(r);
        }
        return s.toString();
    }
}
